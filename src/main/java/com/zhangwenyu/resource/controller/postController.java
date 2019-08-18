package com.zhangwenyu.resource.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zhangwenyu.resource.bean.Msg;
import com.zhangwenyu.resource.bean.Post;
import com.zhangwenyu.resource.bean.User;
import com.zhangwenyu.resource.service.FileUploadService;
import com.zhangwenyu.resource.service.PostService;
import com.zhangwenyu.resource.utils.ResponseUtil;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Logger;

/**
 * 帖子的操作层
 */
@Controller
@RequestMapping("/post")
public class postController {


    String result = null;
    Map<String ,Object> map = new HashMap<String,Object>();


    @Autowired
    PostService postService;

    @Autowired
    FileUploadService fileUploadService;




    @RequestMapping("/all")
    @ResponseBody
    public Msg getAllPost(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        PageHelper.startPage(pn,5);
        List<Post> posts = postService.getAllPost();
        PageInfo page = new PageInfo(posts,5);
        return Msg.success().add("postInfo",page);
    }


    @RequestMapping("/allPost")
    @ResponseBody
    public void getAllPosts(HttpServletResponse response,@RequestParam(value = "postTitle",required = false)String title,
                            @RequestParam(value = "userLevel",required = false)String level,@RequestParam("page")String page,
                            @RequestParam("rows")String rows){


        Post post = new Post();
        post.setPostTitle(title);
        User user = new User();
        user.setUserLevel(level);
        post.setUser(user);

        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        List<Post> posts = postService.getPostByCondition(post);
        long total = postService.countByCondition(post);
        map.put("rows",posts);
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




    @RequestMapping("/getPostById")
    public ModelAndView getPostById(@RequestParam("pid") Integer pid){
        Post post = postService.getPostById(pid);
        List<String>images = new ArrayList<String>();
        if(StringUtil.isNotEmpty(post.getPostImage())){
            images= Arrays.asList(post.getPostImage().split(","));
        }

        ModelAndView modelAndView = new ModelAndView("beforePost");

        modelAndView.addObject("images",images);
        modelAndView.addObject("post",post);

        return modelAndView;
    }

    @RequestMapping("/getSomeOnePosts")
    @ResponseBody
    public Msg getSomeOnePosts(@RequestParam(value = "pn" ,defaultValue = "1") Integer pn, @RequestParam("uid") String uid){

        PageHelper.startPage(pn,5);
       List<String> list = new ArrayList<>();
       list.add(uid);
       List<Post> posts = postService.getSomeOnePosts(list);
        PageInfo page = new PageInfo(posts,5);
        return Msg.success().add("pageInfo",page);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.DELETE)
    public Msg deletePostById(@PathVariable("ids") String ids, HttpServletRequest request){
        if (ids.contains("-")){
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");

            for (String string : str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            //执行批量删除
        }else {
            postService.deletePostById(Integer.parseInt(ids));
            request.setAttribute("isSuccess",true);
        }


        return Msg.success();
    }

    @RequestMapping("/deletePost")
    @ResponseBody
    public void deletePost(HttpServletResponse response,@RequestParam("delIds")String ids){
        List<String> stringList = Arrays.asList(ids.split(","));
        List<Integer> list = new ArrayList<>();
        for (String s : stringList) {
            list.add(Integer.parseInt(s));
        }
        int i = postService.deletePost(list);
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


    @ResponseBody
    @RequestMapping(value = "/addPost" ,method = RequestMethod.POST)
    public Msg addPost(/*@RequestParam("postUid") String uId, @RequestParam("postTitle") String postTitle,
                       @RequestParam("postText") String postText, */HttpServletRequest request,@RequestParam(value = "postImages",required = false) MultipartFile postImages) throws IOException {

        String postUid = request.getParameter("postUid");
        String postTitle = request.getParameter("postTitle");
        String postText = request.getParameter("postText");


        String postImage="";

        if(postImages!=null) {
            String name;

            String originalFilename = postImages.getOriginalFilename();


            String id = UUID.randomUUID().toString().replace("-","").substring(0, 5);
            name = id + "_" + originalFilename;
            String filePath = request.getServletContext().getRealPath("upload");
            filePath = filePath+"/images/";
            int i = fileUploadService.imageUpload(postImages,filePath,name);
            if(i == 1){
                System.out.println("成功了");
                postImage="upload/images/"+name;
            }else {
                return Msg.fail();
            }
        }

        Post post = new Post();
        post.setPostUid(postUid);
        post.setPostTitle(postTitle);
        post.setPostText(postText);
        post.setPostImage(postImage);
        post.setPostTime(new Date());
        int i = postService.insertPost(post);

        return Msg.success().add("id",post.getPostId());
    }


    @RequestMapping("/findPostByConditions")
    @ResponseBody
    public Msg getPostByCondition(@RequestParam(value = "title",required = false) String title,
                                  @RequestParam(value = "types",required = false)String type){

        Post post = new Post();
        if(title!=""&&title!=null){
            post.setPostTitle(title);
        }
        User user = new User();
        if(type!=""&&type!=null){
            user.setUserLevel(type);
        }
        post.setUser(user);
        List<Post> posts = postService.getPostByCondition(post);
        if(posts.size()>0){
            return Msg.success().add("postInfo",posts).add("tipes",posts.size());
        }
        return Msg.fail();
    }

}
