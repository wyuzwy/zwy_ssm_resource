package com.zhangwenyu.resource.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zhangwenyu.resource.bean.CollectKey;
import com.zhangwenyu.resource.bean.Msg;
import com.zhangwenyu.resource.bean.Resource;
import com.zhangwenyu.resource.bean.User;
import com.zhangwenyu.resource.dao.ResourceMapper;
import com.zhangwenyu.resource.service.FileUploadService;
import com.zhangwenyu.resource.service.ResourceService;
import com.zhangwenyu.resource.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    FileUploadService fileUploadService;

    String result = null;
    Map<String ,Object> map = new HashMap<String,Object>();


    @RequestMapping("/all")
    @ResponseBody
    public Msg getAllResource(@RequestParam(value = "pn",defaultValue = "1") Integer pn ){
        //引入PageHelper分页插件
        //在查询之前只需要调用,传入页码以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的这个查询就是一个分页查询
        List<Resource> res =resourceService.getResource();

        //使用pageinfo包装查询后的结果，只需将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询出来的数据,连续显示的页数
        PageInfo page = new PageInfo(res,5);
        //model.addAttribute("pageInfo",page);

        return Msg.success().add("pageInfo",page);

    }


    @RequestMapping("/allResource")
    @ResponseBody
    public void getAllResources(HttpServletResponse response, @RequestParam(value = "resourceName",required = false)String rName,
                                @RequestParam(value = "userLevel",required = false)String rLevel,@RequestParam(value = "resourceCid",required = false)Integer rCid,
                                @RequestParam("page")String page,@RequestParam("rows")String rows){
//        String page = request.getParameter("page");
//        String rows = request.getParameter("rows");
        Resource resource = new Resource();
        resource.setResourceName(rName);
        resource.setResourceCid(rCid);
        User user = new User();
        user.setUserLevel(rLevel);
        resource.setUser(user);
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        List<Resource> resources = resourceService.findResourceByConditions(resource);
        long total = resourceService.countByCondition(resource);
        map.put("rows",resources);
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

    @ResponseBody
    @RequestMapping("/setGood")
    public void setGood(HttpServletResponse response,@RequestParam("delIds") String ids){
        List<String> stringList = Arrays.asList(ids.split(","));
        List<Integer> list = new ArrayList<>();
        for (String s : stringList) {
            list.add(Integer.parseInt(s));
        }
        resourceService.updateResource(list);


        map.put("success","true");
        map.put("msg","标优成功！");
        map.put("delNums",list.size());

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



    @RequestMapping("/deleteResource")
    @ResponseBody
    public void deleteResource(HttpServletResponse response,@RequestParam("delIds") String ids){
        List<String> stringList = Arrays.asList(ids.split(","));
        List<Integer> list = new ArrayList<>();
        for (String s : stringList) {
            list.add(Integer.parseInt(s));
        }

        int i = resourceService.deleteAfterResources(list);
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




    @RequestMapping("/getResourceById")
    public ModelAndView getResourceById(@RequestParam("rid") Integer rid){
        Resource resource = resourceService.getResourceById(rid);

        List<String> images = new ArrayList<String>();
        if(StringUtil.isNotEmpty(resource.getResourceImage())){
            images= Arrays.asList(resource.getResourceImage().split(","));
        }
        ModelAndView modelAndView = new ModelAndView("beforeResource");


        modelAndView.addObject("images",images);
        modelAndView.addObject("resource",resource);
        return modelAndView;
    }
    @RequestMapping("/getSomeOneResource")
    @ResponseBody
    public Msg getSomeOneResource(@RequestParam(value = "pn",defaultValue = "1") Integer pn , @RequestParam("uid") String uid){


        List<Resource> resources;
        if(uid.contains("-")){
            resources=null;
            //批量处理
        }
        else if(uid.contains(",")){
            String [] ownId = uid.split(",");
            List<CollectKey> collectKey = resourceService.getCollect(ownId[0]);
            List<Integer> list2 = new ArrayList<>();
            for (CollectKey collect : collectKey){
                list2.add(collect.getCollectRid());
            }
            PageHelper.startPage(pn,5);
            resources = resourceService.getSomeOneResourceById(list2);
        }else {
            List<String> list = new ArrayList<>();
            list.add(uid);
            PageHelper.startPage(pn,5);
             resources = resourceService.getSomeOneResource(list);
        }

        PageInfo page = new PageInfo(resources,5);
        return Msg.success().add("pageInfo",page);
    }


    @ResponseBody
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.DELETE)
    public Msg deleteResourceById(@PathVariable("ids") String ids,Model model){

        if(ids.contains("-")) {
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");

            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }

            //批量删除


        }else if(ids.contains(",")){
            //取消收藏
            String[] str_ids = ids.split(",");
            CollectKey collectKey = new CollectKey();
            collectKey.setCollectUid(str_ids[0]);
            collectKey.setCollectRid(Integer.parseInt(str_ids[1]));
            resourceService.deleteCollect(collectKey);
            model.addAttribute("isSuccess","true");
        }else{
            resourceService.deleteResource(Integer.parseInt(ids));

            model.addAttribute("isSuccess","true");
        }
        return Msg.success();
    }


    @RequestMapping("/addCollect")
    @ResponseBody
    public Msg addCollect(@RequestParam(value = "uid",required =true) String uid,@RequestParam("rid") Integer rid){

        CollectKey collectKey = new CollectKey();
        collectKey.setCollectUid(uid);
        collectKey.setCollectRid(rid);
        int i=resourceService.searchCollect(collectKey);
        //System.out.println(i);
        if(i == 0){
            resourceService.InsertCollect(collectKey);
            return Msg.success();

        }else{
            return Msg.fail();
        }


    }




    @RequestMapping(value = "/addResource",method = RequestMethod.POST)
    @ResponseBody
    public Msg addResource(HttpServletRequest request,@RequestParam(value = "resourceImages",required = false) MultipartFile resourceImages,
                           @RequestParam("resource") MultipartFile resources) throws IOException {

        String cid = request.getParameter("resourceCid");
        String uid = request.getParameter("resourceUid");
        String rName = request.getParameter("resourceName");
        String level = request.getParameter("resourceLevel");
        String desc = request.getParameter("resourceDesc");
         String filePath = request.getServletContext().getRealPath("upload");

        String iName=null;
        String rsName=null;
        String id = UUID.randomUUID().toString().replace("-", "").substring(0, 5);

        if(resourceImages!=null){
            iName = resourceImages.getOriginalFilename();
            iName = id+"_"+iName;
            String imageFile =  filePath+"/images/";
            fileUploadService.imageUpload(resourceImages,imageFile,iName);
            iName = "upload/images/"+iName;
        }
        if(resources!=null){
            rsName = resources.getOriginalFilename();
            rsName = id+"_"+rsName;
            String resourceFile= filePath+"/resources/";
            fileUploadService.imageUpload(resources,resourceFile,rsName);
            rsName="upload/resources/"+rsName;
        }
        Resource resource = new Resource();
        resource.setResourceCid(Integer.parseInt(cid));
        resource.setResourceUid(uid);
        resource.setResourceName(rName);
        resource.setResourceImage(iName);
        resource.setResourceUrl(rsName);
        resource.setResourceDesc(desc);
        resource.setResourceLevel(level);
        resource.setResourceTime(new Date());
        int i = resourceService.addResource(resource);



        return Msg.success().add("id",resource.getResourceId());
    }



    @RequestMapping("/findResourceByConditions")
    @ResponseBody
    public Msg getResourceByConditions(@RequestParam(value = "name" ,required = false)String name,
                                       @RequestParam(value = "category" ,required = false)String category,
                                       @RequestParam(value = "types" ,required = false)String type){

        //System.out.println(name+"==>"+category+"==>"+type);
        Resource resource = new Resource();
        if(name!=""&&name!=null){
            resource.setResourceName(name);
        }if(category!=""&&name!=null){
            resource.setResourceCid(Integer.parseInt(category));
        }
        User user = new User();
        if(type!=""&&type!=null){
            user.setUserLevel(type);
        }else {
            user.setUserLevel(null);
        }
        resource.setUser(user);
        List<Resource> resources = resourceService.findResourceByConditions(resource);
        if(resources.size()>0){
            return Msg.success().add("pageInfo",resources).add("tipes",resources.size());
        }
        return Msg.fail();
    }

}
