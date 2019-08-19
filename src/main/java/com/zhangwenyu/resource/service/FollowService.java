package com.zhangwenyu.resource.service;

import com.zhangwenyu.resource.bean.*;

import java.util.List;


public interface FollowService {



     List<FollowKey> getUser(String fid) ;

     User findUser(String followedUid) ;

    Student getStudent(String userId) ;

     Teacher getTeacher(String teacherId);

     void deleteFollow(String id1,String id2) ;

     int serchFollow(String uId,String ufId);

     void addFollow(FollowKey followKey);
}
