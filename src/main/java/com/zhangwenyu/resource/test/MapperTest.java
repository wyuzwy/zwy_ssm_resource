package com.zhangwenyu.resource.test;


import com.github.pagehelper.PageHelper;
import com.zhangwenyu.resource.bean.*;
import com.zhangwenyu.resource.dao.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试dao层的工作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CommentMapper commentMapper;


    @Autowired
    ResourceMapper resourceMapper;

    @Autowired
    RegisterMapper registerMapper;


    @Autowired
    CategoryMapper categoryMapper;

    //模糊查找
    @Test
    public void searchUser(){
        User user = new User();
        user.setUserId("1");

        List<User> users = userMapper.findByUserId(user);
        for (User user1 : users) {
            System.out.println(user1);
        }

    }
    //模糊查找资源

    @Test
    public void page(){

        Student student = new Student();
        student.setStudentId("teacher");
        PageHelper.startPage(1,2);
       List<Student> students = studentMapper.selectByCondition(student);
        for (Student student1 : students) {
            System.out.println(student1);
        }


    }

    @Test
    public void testCount(){
        Student student = new Student();
        //student.setStudentId("s");
        long i = studentMapper.countByCondition(student);
        System.out.println(i);

    }





    @Test
    public void searchResource(){
        Resource resource = new Resource();
        resource.setResourceName("");
        resource.setResourceCid(1);
        User user = new User();user.setUserLevel("");
        resource.setUser(user);
        List<Resource> resources = resourceMapper.selectResourceByConditions(resource);
        for (Resource resource1 : resources) {
            System.out.println(resource1);
        }


    }

//批量更新注册表
    @Test
    public void updateRegister(){
        List<String> list = new ArrayList<>();
        list.add("123456");
        list.add("1234567");
        list.add("1234568");
        RegisterExample registerExample = new RegisterExample();
        RegisterExample.Criteria criteria = registerExample.createCriteria();
        criteria.andRegisterIdIn(list);
        List<Register> registers = registerMapper.selectByExample(registerExample);
        for (Register register : registers) {
            System.out.println(register);
            register.setRegisterCheck(0);
        }
        for (Register register : registers) {
            System.out.println(register);
        }
    }

    @Test
    public void testSelectCategory(){
         List<Categories> categories =    categoryMapper.selectByAll();
        for (Categories category : categories) {
            System.out.println(category);
        }
    }


    @Test
    public void setGood(){

    }


    @Test
    public void testAddResource(){
        Resource resource = new Resource();
        resource.setResourceCid(1);
        resource.setResourceUid("zhangwenyu");
        resource.setResourceName("111");
        resource.setResourceUrl("111");
        resource.setResourceLevel("初级");
        resource.setResourceTime(new Date());
        int i = resourceMapper.insertSelective(resource);
        System.out.println(resource);
        System.out.println(resource.getResourceId());
    }


    @Test
    public void testResource(){
        List<Student> students = studentMapper.selectByExample(null);
        for(Student student : students){
            System.out.println(student);
        }
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUserId("zhangwenyu");
        user.setUserLevel("学生");
        user.setUserPassword("123456");
        int i = userMapper.insert(user);
        System.out.println("结果为："+i);
    }

    @Test
    public void testFindAllResource(){
        List<Resource> resources = resourceMapper.selectByExample(null);

        for(Resource resource : resources){
            System.out.println(resource);
        }
    }




}
