package com.zhangwenyu.resource.service;

import com.zhangwenyu.resource.bean.Student;
import com.zhangwenyu.resource.bean.Teacher;
import com.zhangwenyu.resource.bean.User;
import com.zhangwenyu.resource.bean.UserExample;
import com.zhangwenyu.resource.dao.StudentMapper;
import com.zhangwenyu.resource.dao.TeacherMapper;
import com.zhangwenyu.resource.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    public User getUserById(String uid){

        User user = userMapper.selectByPrimaryKey(uid);

        return user;
    }

    public Student getStudentById(String sid) {
        Student student = studentMapper.selectByExampleKey(sid);
        return student;
    }


    public Teacher getTeacherById(String tid){

        Teacher teacher = teacherMapper.selectByExampleKey(tid);

        return teacher;
    }

    public void updateStudent(Student student){

        studentMapper.updateByPrimaryKeySelective(student);

    }

    public void updateTeacher(Teacher teacher){


        teacherMapper.updateByPrimaryKeySelective(teacher);

    }

    public void updatePassword(String uId, String uPassCon) {
        User user = new User();
        user.setUserId(uId);
        user.setUserPassword(uPassCon);
        userMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> searchUser(User user) {

        List<User> users = userMapper.findByUserId(user);
        return users;
    }

    public void addUser(User user){
        userMapper.insertSelective(user);
    }
}
