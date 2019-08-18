package com.zhangwenyu.resource.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangwenyu.resource.bean.*;
import com.zhangwenyu.resource.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/follow")
public class followController {
    @Autowired
    FollowService followService;



    @ResponseBody
    @RequestMapping("/getUser")
    public Msg getUser (@RequestParam("fid")String fid){
        List<UserUtils> userUtils = new ArrayList<UserUtils>();


        List<FollowKey> followKey = followService.getUser(fid);

        for(FollowKey followKey1 :followKey){
            User user = followService.findUser(followKey1.getFollowedUid());


            UserUtils userUtils1 = new UserUtils();

            if(user.getUserLevel().equals("学生")){
                Student student= followService.getStudent(user.getUserId());

                userUtils1.setuId(student.getStudentId());
                userUtils1.setuName(student.getStudentName());
                userUtils1.setuDesc(student.getStudentDesc());
                userUtils1.setuLevel(user.getUserLevel());

                student=null;
            }else{
                Teacher teacher = followService.getTeacher(user.getUserId());

                userUtils1.setuId(teacher.getTeacherId());
                userUtils1.setuName(teacher.getTeacherName());
                userUtils1.setuDesc(teacher.getTeacherDesc());
                userUtils1.setuLevel(user.getUserLevel());
                teacher = null;
            }
            userUtils.add(userUtils1);
            user = null;
            userUtils1=null;
        }

        return Msg.success().add("pageInfo",userUtils);
    }



    @ResponseBody
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.DELETE)
    public Msg deleteResourceById(@PathVariable("ids") String ids) {
        String[] str_ids = ids.split("-");
        String id1 = str_ids[0];
        String id2 = str_ids[1];
        followService.deleteFollow(id1,id2);

        return Msg.success();
    }

    @ResponseBody
    @RequestMapping("/addFollow")
    public Msg addFollow(@RequestParam(value = "uId",required = true) String Uid,@RequestParam("ufId") String ufId){
        int i= followService.serchFollow(Uid,ufId);
        if(i==1){
            return Msg.fail();
        }else{
            FollowKey followKey = new FollowKey();
            followKey.setFollowUid(Uid);
            followKey.setFollowedUid(ufId);
            followService.addFollow(followKey);
            return Msg.success();
        }
    }
}
