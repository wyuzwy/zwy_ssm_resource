package com.zhangwenyu.resource.dao;

import com.zhangwenyu.resource.bean.Resource;
import com.zhangwenyu.resource.bean.ResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {
    long countByExample(ResourceExample example);

    int deleteByExample(ResourceExample example);

    int deleteByPrimaryKey(Integer resourceId);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExample(ResourceExample example);

    List<Resource> selectByExampleWithUser(ResourceExample example);

    List<Resource> selectResourceByConditions(Resource resource);

    Resource selectByPrimaryKey(Integer resourceId);

    long countByConditions(Resource resource);

    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}