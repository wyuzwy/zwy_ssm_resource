package com.zhangwenyu.resource.service;


import com.zhangwenyu.resource.bean.Teacher;


import java.util.List;





public interface TeacherService {



     List<Teacher>selectByCondition(Teacher teacher);

     long countByCondition(Teacher teacher);


     void deleteTeacher(List<String> list);


     void addTeacher(Teacher teacher);
}
