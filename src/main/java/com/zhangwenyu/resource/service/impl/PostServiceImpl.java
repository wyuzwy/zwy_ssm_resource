package com.zhangwenyu.resource.service.impl;

import com.zhangwenyu.resource.bean.Post;
import com.zhangwenyu.resource.bean.PostExample;
import com.zhangwenyu.resource.dao.PostMapper;
import com.zhangwenyu.resource.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 帖子的业务层
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;



    public List<Post> getAllPost(){

        List<Post> posts = postMapper.selectByExampleWithUser(null);

        return posts;
    }


    public Post getPostById(Integer pid) {

        Post post = postMapper.selectByPrimaryKeyWithComment(pid);
        return post;
    }


    public List<Post> getSomeOnePosts(List<String> uid){
        PostExample postExample = new PostExample();
        PostExample.Criteria criteria = postExample.createCriteria();
        criteria.andPostUidIn(uid);
        List<Post> posts = postMapper.selectByExampleWithUser(postExample);
        return posts;


    }


    public void deletePostById(int parseInt) {
        postMapper.deleteByPrimaryKey(parseInt);
    }




    public int insertPost(Post post){

      int i =  postMapper.insertSelective(post);

      return i;
    }

    public List<Post> getPostByCondition(Post post) {
        List<Post> posts = postMapper.selectPostByConditions(post);
        return posts;
    }

    public long countByCondition(Post post){
        long i = postMapper.countByCondition(post);
        return i;
    }



    public int deletePost(List<Integer>list){
        PostExample postExample = new PostExample();
        PostExample.Criteria criteria = postExample.createCriteria();
        criteria.andPostIdIn(list);
        int i = 0;
        i = postMapper.deleteByExample(postExample);
        return  i;
    }
}
