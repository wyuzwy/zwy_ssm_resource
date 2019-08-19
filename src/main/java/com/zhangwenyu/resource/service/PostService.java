package com.zhangwenyu.resource.service;


import com.zhangwenyu.resource.bean.Post;


import java.util.List;


/**
 * 帖子的业务层
 */

public interface PostService {



     List<Post> getAllPost();

     Post getPostById(Integer pid);

     List<Post> getSomeOnePosts(List<String> uid);

     void deletePostById(int parseInt);

     int insertPost(Post post);

     List<Post> getPostByCondition(Post post) ;

     long countByCondition(Post post);

     int deletePost(List<Integer>list);
}
