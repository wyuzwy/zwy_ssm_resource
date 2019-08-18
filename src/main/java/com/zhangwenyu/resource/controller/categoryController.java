package com.zhangwenyu.resource.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.zhangwenyu.resource.bean.Categories;
import com.zhangwenyu.resource.bean.Category;
import com.zhangwenyu.resource.bean.CategoryKey;
import com.zhangwenyu.resource.bean.Msg;
import com.zhangwenyu.resource.service.CategoryService;
import com.zhangwenyu.resource.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class categoryController {

    String result = null;
    Map<String ,Object> map = new HashMap<String,Object>();

    @Autowired
    CategoryService categoryService;


    //查询所有资源类别信息
    @RequestMapping("/allCategory")
    @ResponseBody
    public Msg getAllCategory(){
        List<Categories> categorys = categoryService.allCategory();
        return Msg.success().add("cates",categorys);
    }


    //查询所有资源类别信息
    @RequestMapping("/allCategoryList")
    @ResponseBody
    public void getAllCategory(HttpServletResponse response){

        List<Categories> categoryList = categoryService.allCategory();
        Categories categories = new Categories(-1,"请选择...","");
        categoryList.add(0,categories);
        result = JSON.toJSONString(categoryList);
        if (result != null) {
            try {
                ResponseUtil.write(response,result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return;
    }


    @RequestMapping("/allAfterCategory")
    @ResponseBody
    public void getAfterCategory(HttpServletResponse response, @RequestParam(value = "categoryName",required = false)String name,
                                 @RequestParam("rows")String rows,@RequestParam(value = "page",required = false)String page){
        Categories categories = new Categories();
        categories.setCategoryName(name);
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(rows));
        List<Categories> categories1 =categoryService.allAfterCategory(categories);
         long total = categoryService.countByCondition(categories);
        map.put("rows",categories1);
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

    @RequestMapping("/addCategory")
    public void addCategory(HttpServletResponse response,@RequestParam("categoryName") String name,@RequestParam("categoryDesc") String desc){

        //System.out.println(name+"====>"+desc);
        Category category = new Category();
        category.setCategoryName(name);
        category.setCategoryDesc(desc);
        int i = categoryService.addCategory(category);

        if (i!=0){
            map.put("success", "true");
            map.put("msg", "添加成功！");
        }else {
            map.put("success", "false");
            map.put("msg", "添加失败，请重试！");
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


    @RequestMapping("/updateCategory")
    public void updateCategory(HttpServletResponse response,@RequestParam("categoryId") String Id,
                               @RequestParam("categoryName") String name,@RequestParam("categoryDesc")String desc){

        //System.out.println(Id+"====>"+name+"====>"+desc);
        Category category = new Category();
        category.setCategoryId(Integer.parseInt(Id));
        category.setCategoryName(name);
        category.setCategoryDesc(desc);
        int i = categoryService.updateCategory(category);

        if (i!=0){

            map.put("success", "true");
            map.put("msg", "修改成功！");
        }else {
            map.put("success", "false");
            map.put("msg", "修改失败，请重试！");
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

}
