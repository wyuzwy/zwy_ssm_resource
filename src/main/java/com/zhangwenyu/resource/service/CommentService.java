package com.zhangwenyu.resource.service;


import com.zhangwenyu.resource.bean.Comment;
import com.zhangwenyu.resource.bean.Comments;


import java.util.List;


public interface CommentService {



     List<Comment> getAllComment();

     void addComment(Comment comment) ;

     List<Comments> getAllCommentWithPostTitle();
     long countComment();

     int deleteComment(List<Integer> list) ;
}
