package com.zhangwenyu.resource.service;


import com.zhangwenyu.resource.bean.Student;


import java.util.List;


public interface StudentService {

    List<Student> getAllStudent(Student student);


     long countStudent(Student student);



     void deleteUser(List<String> delIds);

     void addStudent(Student student);
}
