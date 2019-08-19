package com.zhangwenyu.resource.service.impl;

import com.zhangwenyu.resource.bean.CollectExample;
import com.zhangwenyu.resource.bean.CollectKey;
import com.zhangwenyu.resource.bean.Resource;
import com.zhangwenyu.resource.bean.ResourceExample;
import com.zhangwenyu.resource.dao.CollectMapper;
import com.zhangwenyu.resource.dao.ResourceMapper;
import com.zhangwenyu.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private CollectMapper collectMapper;

    public List<Resource> getResource(){
        List<Resource> resources = resourceMapper.selectByExampleWithUser(null);
        return resources;
    }

    public Resource getResourceById(Integer rid) {

        Resource resource = resourceMapper.selectByPrimaryKey(rid);
        return resource;
    }
    public List<Resource> getSomeOneResource(List<String> listId){
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andResourceUidIn(listId);
        List<Resource> resources = resourceMapper.selectByExampleWithUser(resourceExample);
        return resources;
    }

    public void deleteResource(int parseInt) {

        resourceMapper.deleteByPrimaryKey(parseInt);

    }

    public List<CollectKey> getCollect(String s) {
        List<String> list = new ArrayList<>();
        list.add(s);
        CollectExample example = new CollectExample();
        CollectExample.Criteria criteria = example.createCriteria();
        criteria.andCollectUidIn(list);
        List<CollectKey> collectKey = collectMapper.selectByExample(example);
        return collectKey;
    }

    public List<Resource> getSomeOneResourceById(List<Integer> list2) {
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andResourceIdIn(list2);
        List<Resource> resources = resourceMapper.selectByExampleWithUser(resourceExample);
        return resources;
    }

    public void deleteCollect(CollectKey collectKey) {
        collectMapper.deleteByPrimaryKey(collectKey);
    }

    public int searchCollect(CollectKey collectKey) {
          List<String> listUid = new ArrayList<>();
          List<Integer> listRid = new ArrayList<>();
          listUid.add(collectKey.getCollectUid());
          listRid.add(collectKey.getCollectRid());
          CollectExample example = new CollectExample();
          CollectExample.Criteria criteria = example.createCriteria();
          criteria.andCollectUidIn(listUid);
          criteria.andCollectRidIn(listRid);
          List<CollectKey> collectKey1 = collectMapper.selectByExample(example);
          int i = 0;
          if(collectKey1.size()>0){
              i=1;
          }
        return i;
    }

    public void InsertCollect(CollectKey collectKey){
        collectMapper.insert(collectKey);

    }

    public int addResource(Resource resource){


        int i = resourceMapper.insertSelective(resource);
        //System.out.println(resource);


        return i;
    }

    public List<Resource> findResourceByConditions(Resource resource) {
        List<Resource> resources = resourceMapper.selectResourceByConditions(resource);
        return resources;
    }

    public long countByCondition(Resource resource){
        long i = resourceMapper.countByConditions(resource);
        return i;
    }

    public void updateResource(List<Integer> list) {
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andResourceIdIn(list);
        List<Resource> resources = resourceMapper.selectByExample(resourceExample);
        for (Resource resource : resources) {
            resource.setResourceGood(1);
            resourceMapper.updateByPrimaryKeySelective(resource);
        }


    }

    public int deleteAfterResources(List<Integer> list) {
        ResourceExample resourceExample = new ResourceExample();
        ResourceExample.Criteria criteria = resourceExample.createCriteria();
        criteria.andResourceIdIn(list);
        int i =0;
        i = resourceMapper.deleteByExample(resourceExample);
        return i;
    }
}
