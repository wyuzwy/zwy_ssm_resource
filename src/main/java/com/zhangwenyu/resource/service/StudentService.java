package com.zhangwenyu.resource.service;


import com.zhangwenyu.resource.bean.Student;
import com.zhangwenyu.resource.bean.StudentExample;
import com.zhangwenyu.resource.bean.UserExample;
import com.zhangwenyu.resource.dao.StudentMapper;
import com.zhangwenyu.resource.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    StudentMapper studentMapper;
    public List<Student> getAllStudent(Student student){
        List<Student> students= studentMapper.selectByCondition(student);
        return students;
    }


    public long countStudent(Student student){
        long i = studentMapper.countByCondition(student);
        return i;

    }



    public void deleteUser(List<String> delIds) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdIn(delIds);
        userMapper.deleteByExample(example);

    }

    public void addStudent(Student student){
        studentMapper.insert(student);
    }
}
