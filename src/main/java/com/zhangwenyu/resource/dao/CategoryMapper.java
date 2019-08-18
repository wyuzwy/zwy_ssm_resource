package com.zhangwenyu.resource.dao;

import com.zhangwenyu.resource.bean.Categories;
import com.zhangwenyu.resource.bean.Category;
import com.zhangwenyu.resource.bean.CategoryExample;
import com.zhangwenyu.resource.bean.CategoryKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(CategoryKey key);

    int insert(Category record);

    int insertSelective(Category record);

    List<Categories> selectByAll();

    List<Categories> selectAllByName(Categories categories);

    long countByCondition(Categories categories);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(CategoryKey key);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}