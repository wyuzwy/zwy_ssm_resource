package com.zhangwenyu.resource.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.zhangwenyu.resource.bean.Msg;
import com.zhangwenyu.resource.bean.Teacher;
import com.zhangwenyu.resource.service.TeacherService;
import com.zhangwenyu.resource.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class teacherController {

    @Autowired
    TeacherService teacherService;

    String result = null;
    Map<String ,Object> map = new HashMap<String,Object>();
    @RequestMapping("/allTeacher")
    @ResponseBody
    public void getAllTeacher(HttpServletResponse response, @RequestParam(value = "teacherId",required = false)String teacherId,
                              HttpServletRequest request){
                              /*@RequestParam("page")String page,@RequestParam("rows")String rows*/

        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        List<Teacher> teachers =teacherService.selectByCondition(teacher);

        long total = teacherService.countByCondition(teacher);

        map.put("rows",teachers);
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
        return;
    }

    @RequestMapping("/deleteTeacher")
    @ResponseBody
    public void deleteTeacher(@RequestParam("delIds")String ids,HttpServletResponse response){
        List<String> idList= Arrays.asList(ids.split(","));
        teacherService.deleteTeacher(idList);

        map.put("success","true");
        map.put("msg","删除成功！");
        map.put("delNums",idList.size());

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
