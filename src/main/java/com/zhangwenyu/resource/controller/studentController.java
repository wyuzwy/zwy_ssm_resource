package com.zhangwenyu.resource.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.zhangwenyu.resource.bean.Msg;
import com.zhangwenyu.resource.bean.Student;
import com.zhangwenyu.resource.service.StudentService;
import com.zhangwenyu.resource.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class studentController {
    String result = null;
    Map<String ,Object> map = new HashMap<String,Object>();

    @Autowired
    StudentService studentService;


    @RequestMapping("/allStudent")
    @ResponseBody
    public void getAllStudent( HttpServletResponse response ,HttpServletRequest request){

        String studentId = request.getParameter("studentId");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        Student student = new Student();
        student.setStudentId(studentId);
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        List<Student> students =  studentService.getAllStudent(student);
        long total = studentService.countStudent(student);
        map.put("rows",students);
        map.put("total",total);

        result = JSON.toJSONString(map);
        map.clear();
        if (result!=null){
            try {
                ResponseUtil.write(response,result);
                result=null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ;
    }


    @RequestMapping("/deleteStudent")
    @ResponseBody
    public void deleteStudent(@RequestParam("delIds") String ids ,HttpServletResponse response){
        List<String> delIds = Arrays.asList( ids.split(","));

        studentService.deleteUser(delIds);


        map.put("success","true");
        map.put("msg","删除成功！");
        map.put("delNums",delIds.size());

        result = JSON.toJSONString(map);
        map.clear();
        if (result!=null){
            try {
                ResponseUtil.write(response,result);
                result=null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ;


    }


}
