package com.zhangwenyu.resource.dao;

import com.zhangwenyu.resource.bean.Register;
import com.zhangwenyu.resource.bean.RegisterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegisterMapper {
    long countByExample(RegisterExample example);

    int deleteByExample(RegisterExample example);

    int deleteByPrimaryKey(String registerId);

    int insert(Register record);

    int insertSelective(Register record);

    List<Register> selectByExample(RegisterExample example);

    Register selectByPrimaryKey(String registerId);

    int updateByExampleSelective(@Param("record") Register record, @Param("example") RegisterExample example);

    int updateByExample(@Param("record") Register record, @Param("example") RegisterExample example);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}