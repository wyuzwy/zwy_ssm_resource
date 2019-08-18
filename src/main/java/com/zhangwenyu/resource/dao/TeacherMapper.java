package com.zhangwenyu.resource.dao;

import com.zhangwenyu.resource.bean.Teacher;
import com.zhangwenyu.resource.bean.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByCondition(Teacher teacher);
    long countByCondition(Teacher teacher);

    Teacher selectByExampleKey(String teacherId);

    List<Teacher> selectByExample(TeacherExample example);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher teacher);
}