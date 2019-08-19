package com.zhangwenyu.resource.service;

import com.zhangwenyu.resource.bean.Student;
import com.zhangwenyu.resource.bean.Teacher;
import com.zhangwenyu.resource.bean.User;

import java.util.List;


public interface UserService {


     User getUserById(String uid);

     Student getStudentById(String sid) ;


     Teacher getTeacherById(String tid);

     void updateStudent(Student student);

     void updateTeacher(Teacher teacher);

     void updatePassword(String uId, String uPassCon) ;

     List<User> searchUser(User user) ;

     void addUser(User user);
}
