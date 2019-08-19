package com.zhangwenyu.resource.service;

import com.zhangwenyu.resource.bean.Categories;
import com.zhangwenyu.resource.bean.Category;


import java.util.List;

public interface CategoryService {


     List<Categories> allCategory();


     List<Categories> allAfterCategory(Categories categories);

     long countByCondition(Categories categories);

     int addCategory(Category category);


     int updateCategory(Category category);
}
