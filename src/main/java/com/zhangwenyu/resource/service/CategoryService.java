package com.zhangwenyu.resource.service;

import com.zhangwenyu.resource.bean.Categories;
import com.zhangwenyu.resource.bean.Category;
import com.zhangwenyu.resource.bean.CategoryKey;
import com.zhangwenyu.resource.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public List<Categories> allCategory(){
        List<Categories> categories = categoryMapper.selectByAll();
        return categories;
    }


    public List<Categories> allAfterCategory(Categories categories) {
        List<Categories> categories1 = categoryMapper.selectAllByName(categories);
        return categories1;
    }

    public long countByCondition(Categories categories){
        long i = categoryMapper.countByCondition(categories);
        return i;

    }

    public int addCategory(Category category){

        int i = 0;
        i = categoryMapper.insert(category);
        return i;
    }


    public int updateCategory(Category category){

        int i=0;
        i=categoryMapper.updateByPrimaryKey(category);
        return i;
    }
}
