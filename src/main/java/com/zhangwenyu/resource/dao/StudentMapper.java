package com.zhangwenyu.resource.dao;

import com.zhangwenyu.resource.bean.Student;
import com.zhangwenyu.resource.bean.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByCondition(Student student);
    long countByCondition(Student student);


    Student selectByExampleKey(String StudentId);
    List<Student> selectByExample(StudentExample example);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student student);
}