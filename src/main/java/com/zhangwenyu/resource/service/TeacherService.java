package com.zhangwenyu.resource.service;


import com.zhangwenyu.resource.bean.Teacher;
import com.zhangwenyu.resource.bean.TeacherExample;
import com.zhangwenyu.resource.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class TeacherService {

    @Autowired
    TeacherMapper teacherMapper;


    public List<Teacher>selectByCondition(Teacher teacher){
        List<Teacher> teachers = teacherMapper.selectByCondition(teacher);
        return teachers;
    }

    public long countByCondition(Teacher teacher){

        long i = teacherMapper.countByCondition(teacher);
        return i;

    }


    public void deleteTeacher(List<String> list){
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andTeacherIdIn(list);
        teacherMapper.deleteByExample(teacherExample);
    }


    public void addTeacher(Teacher teacher){

        teacherMapper.insertSelective(teacher);
    }
}
