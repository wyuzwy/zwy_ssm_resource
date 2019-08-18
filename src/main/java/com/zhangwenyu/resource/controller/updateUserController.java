package com.zhangwenyu.resource.controller;

import com.zhangwenyu.resource.bean.Msg;
import com.zhangwenyu.resource.bean.Student;
import com.zhangwenyu.resource.bean.User;
import com.zhangwenyu.resource.bean.UserUtils;
import com.zhangwenyu.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/update")
public class updateUserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/update")
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
                return Msg.success().add("msg","修改成功！请重新登录！");
            }else{
                return Msg.fail().add("msg","两次新密码不正确！");
            }
        }else{
            return Msg.fail().add("msg","密码错误！");
        }


    }
}
