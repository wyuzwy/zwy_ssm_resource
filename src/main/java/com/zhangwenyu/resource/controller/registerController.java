package com.zhangwenyu.resource.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.zhangwenyu.resource.bean.*;
import com.zhangwenyu.resource.service.RegisterService;
import com.zhangwenyu.resource.service.StudentService;
import com.zhangwenyu.resource.service.TeacherService;
import com.zhangwenyu.resource.service.UserService;
import com.zhangwenyu.resource.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Controller
@RequestMapping("/register")
public class registerController {

    String result = null;
    Map<String ,Object> map = new HashMap<String,Object>();

    @Autowired
    RegisterService registerService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;


    @Autowired
    UserService userService;

    @RequestMapping("/checkId")
    @ResponseBody
    public Msg getCheckId(@RequestParam("userId") String uid){
        Register register = registerService.getCheckId(uid);
        if(register==null){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @RequestMapping(value = "/addRegister", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveRegister(@RequestParam("registerId")String registerId,
                            @RequestParam(value="registerClass",required = false)String registerClass,@RequestParam("registerLevel")String registerLevel,
                            @RequestParam("registerPasswordConfirm")String registerPasswordConfirm){
       Register register = new Register();
       register.setRegisterId(registerId);
       register.setRegisterPassword(registerPasswordConfirm);
       register.setRegisterClass(registerClass);
       register.setRegisterLevel(registerLevel);
       registerService.saveRegister(register);

        return Msg.success();
    }

    @RequestMapping("/allRegister")
    @ResponseBody
    public void getCheckId(HttpServletResponse response, @RequestParam("page")String page,@RequestParam("rows")String rows){

        List<Integer> list = new ArrayList<>();
        list.add(0);
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        List<Register> registers = registerService.selectByCheck(list);
        long total = registerService.countByCheck(list);
        map.put("rows",registers);
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


    @RequestMapping("/checkOk")
    @ResponseBody
    public void checkOk(HttpServletResponse response,@RequestParam("delIds") String ids){
        List<String> idList = Arrays.asList(ids.split(","));
        List<Register> registers = registerService.selectById(idList);
        for (Register register : registers) {
            register.setRegisterCheck(1);
            System.out.println(register);
        }
        registerService.updateRegister(registers);

        for (Register register : registers) {
            User user = new User();
            user.setUserId(register.getRegisterId());
            user.setUserPassword(register.getRegisterPassword());
            user.setUserLevel(register.getRegisterLevel());
            userService.addUser(user);
            user=null;
            if(register.getRegisterLevel().equals("学生")){
                Student student = new Student();
                student.setStudentId(register.getRegisterId());
                student.setStudentName(register.getRegisterName());
                student.setStudentClass(register.getRegisterClass());
                studentService.addStudent(student);
                student=null;
            }else{
                Teacher teacher = new Teacher();
                teacher.setTeacherId(register.getRegisterId());
                teacher.setTeacherName(register.getRegisterName());
                teacherService.addTeacher(teacher);
                teacher=null;
            }


        }

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
