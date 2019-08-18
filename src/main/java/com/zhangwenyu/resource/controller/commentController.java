package com.zhangwenyu.resource.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangwenyu.resource.bean.Comment;
import com.zhangwenyu.resource.bean.Comments;
import com.zhangwenyu.resource.bean.Msg;
import com.zhangwenyu.resource.service.CommentService;
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
@RequestMapping("/comment")
public class commentController {

    String result = null;
    Map<String ,Object> map = new HashMap<String,Object>();

    @Autowired
    CommentService commentService;


    @RequestMapping("/all")
    @ResponseBody
    public Msg getAllComment(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,5);
        List<Comments> comms = commentService.getAllCommentWithPostTitle();
        PageInfo page = new PageInfo(comms,5);
        return Msg.success().add("commentInfo",page);
    }

    @RequestMapping("/allComment")
    @ResponseBody
    public void getAllComments(HttpServletResponse response,@RequestParam("page")String page,
                               @RequestParam("rows")String rows){
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        List<Comments> comments = commentService.getAllCommentWithPostTitle();
        long total = commentService.countComment();

        map.put("rows",comments);
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




    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    @ResponseBody
    public Msg addComment(@RequestParam("commentUid") String uId,@RequestParam("commentPid")String pId,@RequestParam("commentText")String text){

        Comment comment = new Comment();
        comment.setCommentPid(Integer.parseInt(pId));
        comment.setCommentUid(uId);
        comment.setCommentText(text);
        comment.setCommentTime(new Date());
        commentService.addComment(comment);
        return Msg.success();
    }

    @RequestMapping("/deleteComment")
    @ResponseBody
    public void deleteComment(HttpServletResponse response,@RequestParam("delIds")String ids){
        List<String> stringList = Arrays.asList(ids.split(","));
        List<Integer> list = new ArrayList<>();
        for (String s : stringList) {
            list.add(Integer.parseInt(s));
        }
        int i = commentService.deleteComment(list);

        if (i != 0){
            map.put("success","true");
            map.put("msg","删除成功！");
            map.put("delNums",list.size());
        }else {
            map.put("success", "false");
            map.put("msg", "删除失败，请重试！");
        }

        result = JSON.toJSONString(map);
        map.clear();
        if (result != null) {
            try {
                ResponseUtil.write(response, result);
                result = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return;

    }


}
