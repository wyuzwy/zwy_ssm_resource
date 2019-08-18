package com.zhangwenyu.resource.controller;

import com.zhangwenyu.resource.bean.*;
import com.zhangwenyu.resource.service.FollowService;
import com.zhangwenyu.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    UserService userService;

    @Autowired
    FollowService followService;






    @RequestMapping("/getUserById")
    public ModelAndView getUserById(@RequestParam("uid") String  uid ,@RequestParam("tag") Integer tag){
        User user =userService.getUserById(uid);
        ModelAndView modelAndView;
        if (tag == 0) {
            modelAndView= new ModelAndView("beforeUser");
        }else{
            modelAndView= new ModelAndView("beforeOwnInfo");
        }

        UserUtils userUtils = new UserUtils();
        if(user.getUserLevel().equals("学生")){
            Student student =userService.getStudentById(uid);
            userUtils.setuId(student.getStudentId());
            userUtils.setuName(student.getStudentName());
            userUtils.setuSex(student.getStudentSex());
            userUtils.setuClass(student.getStudentClass());
            userUtils.setuBirth(student.getStudentBirth());
            userUtils.setuDesc(student.getStudentDesc());



        }else {
            Teacher teacher = userService.getTeacherById(uid);
            userUtils.setuId(teacher.getTeacherId());
            userUtils.setuName(teacher.getTeacherName());
            userUtils.setuSex(teacher.getTeacherSex());
            userUtils.setuBirth(teacher.getTeacherBirth());
            userUtils.setuDesc(teacher.getTeacherDesc());

        }
        modelAndView.addObject("user",userUtils);
        modelAndView.addObject("target",user.getUserLevel());

        return modelAndView;
    }

    @RequestMapping("/findUser")
    @ResponseBody
    public Msg getUser(@RequestParam("userId") String uid){
        //System.out.println(uid);
        User user = new User();
        user.setUserId(uid);
        List<User> users = userService.searchUser(user);

        if (users.size()>0){
            List<UserUtils> userUtils = new ArrayList<UserUtils>();
            for (User user1 : users) {
                UserUtils userUtils1 = new UserUtils();
                if(user1.getUserLevel().equals("学生")){
                    Student student= followService.getStudent(user1.getUserId());
                    //System.out.println(student);
                    userUtils1.setuId(student.getStudentId());
                    userUtils1.setuName(student.getStudentName());
                    userUtils1.setuDesc(student.getStudentDesc());
                    userUtils1.setuLevel(user1.getUserLevel());
                }else {
                    Teacher teacher = followService.getTeacher(user1.getUserId());
                    //System.out.println(teacher);
                    userUtils1.setuId(teacher.getTeacherId());
                    userUtils1.setuName(teacher.getTeacherName());
                    userUtils1.setuDesc(teacher.getTeacherDesc());
                    userUtils1.setuLevel(user1.getUserLevel());
                }
                userUtils.add(userUtils1);
            }

            return Msg.success().add("list",userUtils);
        }
        else {
            return Msg.fail();
        }
    }



    @RequestMapping("/login")
    public ModelAndView getLogin(@RequestParam("userId") String  userId, @RequestParam("userPassword") String userPassword, HttpSession httpSession){
        User user =userService.getUserById(userId);
        ModelAndView modelAndView;
        String error = null;
        if(user==null){
            error="用户名不存在！";
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("error",error);
           // System.out.println(error);

        }else{
            if(!user.getUserPassword().equals(userPassword)){
                error="密码不正确！！";
                modelAndView = new ModelAndView("login");
                modelAndView.addObject("error",error);
                //System.out.println(error);

            }else if(user.getUserLevel().equals("学生")||user.getUserLevel().equals("教师")){
                modelAndView = new ModelAndView("main");
                httpSession.setAttribute("currentUser",user);
                //modelAndView.addObject("currentUser",user);
            }else {
                modelAndView = new ModelAndView("afterMain");
                httpSession.setAttribute("currentUser",user);
            }
        }
        return modelAndView;
    }

    @RequestMapping("/exit")
    public ModelAndView exit(/*@RequestParam("uid")String uid,*/HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("login");
        //清空session域
        httpSession.invalidate();
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = "/edit/{uId}" , method = RequestMethod.PUT)
    public Msg saveUser(@RequestParam("uId") String uId, @RequestParam("uName") String uName,
                        @RequestParam("uSex") String uSex, @RequestParam(value = "uClass" ,required = false) String uClass,
                        @RequestParam("uBirth")String uBirth,@RequestParam("uDesc") String uDesc,@RequestParam("uLevel") String uLevel) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");
        Date dt = df.parse(uBirth);
        if(uLevel.equals("学生")){
            Student student = new Student();
            student.setStudentId(uId);
            student.setStudentName(uName);
            student.setStudentSex(uSex);
            student.setStudentBirth(dt);
            student.setStudentClass(uClass);
            student.setStudentDesc(uDesc);
            userService.updateStudent(student);
        }else{

            Teacher teacher = new Teacher();
            teacher.setTeacherId(uId);
            teacher.setTeacherName(uName);
            teacher.setTeacherSex(uSex);
            teacher.setTeacherBirth(dt);
            teacher.setTeacherDesc(uDesc);
            userService.updateTeacher(teacher);
        }
        //ModelAndView modelAndView = new ModelAndView("beforeOwnInfo");
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/update/{uid}" , method = RequestMethod.PUT)
    public Msg updatePassword(@RequestParam("userId") String userId,@RequestParam("uPass") String uPass,
                              @RequestParam("NuPass") String NuPass,@RequestParam("uPassConfirm") String uPassConfirm){

        User user = userService.getUserById(userId);
        //System.out.println(user);
        if(uPass.equals(user.getUserPassword())){
            if(NuPass.isEmpty()|| uPassConfirm.isEmpty()){
                return Msg.fail().add("msg","新密码不能为空！");
            }
            else if(NuPass.equals(uPassConfirm)){
                userService.updatePassword(userId,uPassConfirm);
                return Msg.success().add("msg","修改成功！2s后请重新登录！");
            }else{
                return Msg.fail().add("msg","两次新密码不正确！");
            }
        }else{
            return Msg.fail().add("msg","密码错误！");
        }


    }

}
