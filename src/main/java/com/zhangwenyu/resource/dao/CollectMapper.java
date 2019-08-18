package com.zhangwenyu.resource.dao;

import com.zhangwenyu.resource.bean.CollectExample;
import com.zhangwenyu.resource.bean.CollectKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectMapper {
    long countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(CollectKey key);

    int insert(CollectKey record);

    int insertSelective(CollectKey record);

    List<CollectKey> selectByExample(CollectExample example);

    int updateByExampleSelective(@Param("record") CollectKey record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") CollectKey record, @Param("example") CollectExample example);
}