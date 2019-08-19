package com.zhangwenyu.resource.service;

import com.zhangwenyu.resource.bean.CollectKey;
import com.zhangwenyu.resource.bean.Resource;

import java.util.List;


public interface ResourceService {

     List<Resource> getResource();

     Resource getResourceById(Integer rid) ;
     List<Resource> getSomeOneResource(List<String> listId);

     void deleteResource(int parseInt);

     List<CollectKey> getCollect(String s);

     List<Resource> getSomeOneResourceById(List<Integer> list2);

     void deleteCollect(CollectKey collectKey) ;

     int searchCollect(CollectKey collectKey) ;

     void InsertCollect(CollectKey collectKey);

     int addResource(Resource resource);

     List<Resource> findResourceByConditions(Resource resource) ;

     long countByCondition(Resource resource);

     void updateResource(List<Integer> list);


     int deleteAfterResources(List<Integer> list) ;
}
