package com.zhangwenyu.resource.service.impl;

import com.zhangwenyu.resource.bean.*;
import com.zhangwenyu.resource.dao.FollowMapper;
import com.zhangwenyu.resource.dao.StudentMapper;
import com.zhangwenyu.resource.dao.TeacherMapper;
import com.zhangwenyu.resource.dao.UserMapper;
import com.zhangwenyu.resource.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    FollowMapper followMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;

    public List<FollowKey> getUser(String fid) {
        List<String> list = new ArrayList<String>();
        list.add(fid);
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andFollowUidIn(list);
        List<FollowKey> follow =followMapper.selectByExample(followExample);
        return follow;
    }

    public User findUser(String followedUid) {
        User user = userMapper.selectByPrimaryKey(followedUid);
        return user;

    }

    public Student getStudent(String userId) {
        Student student = studentMapper.selectByExampleKey(userId);
        return student;
    }

    public Teacher getTeacher(String teacherId){
        Teacher teacher = teacherMapper.selectByExampleKey(teacherId);
        return teacher;

    }

    public void deleteFollow(String id1,String id2) {
        FollowKey followKey = new FollowKey();
        followKey.setFollowUid(id1);
        followKey.setFollowedUid(id2);
        followMapper.deleteByPrimaryKey(followKey);
    }

    public int serchFollow(String uId,String ufId){
        List<String> listUid = new ArrayList<>();
        List<String> listUfid = new ArrayList<>();
        listUid.add(uId);
        listUfid.add(ufId);
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andFollowUidIn(listUid);
        criteria.andFollowedUidIn(listUfid);
        List<FollowKey> followKey = followMapper.selectByExample(followExample);
        int i = 0;
        if(followKey.size()>0){
            i=1;
        }
        return i;
    }

    public void addFollow(FollowKey followKey){
        followMapper.insert(followKey);

    }
}
