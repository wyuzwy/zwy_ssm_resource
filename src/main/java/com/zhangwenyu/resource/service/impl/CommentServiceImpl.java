package com.zhangwenyu.resource.service.impl;


import com.zhangwenyu.resource.bean.Comment;
import com.zhangwenyu.resource.bean.CommentExample;
import com.zhangwenyu.resource.bean.Comments;
import com.zhangwenyu.resource.dao.CommentMapper;
import com.zhangwenyu.resource.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;


    public List<Comment> getAllComment(){
        List<Comment> comments = commentMapper.selectByExample(null);
        return comments;

    }

    public void addComment(Comment comment) {

        commentMapper.insertSelective(comment);
    }

    public List<Comments> getAllCommentWithPostTitle(){
        List<Comments> comments = commentMapper.selectAllComment();
        return comments;
    }
    public long countComment(){
        long i = commentMapper.countByExample(null);
        return i;
    }

    public int deleteComment(List<Integer> list) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentIdIn(list);
        int i = 0;
        i = commentMapper.deleteByExample(commentExample);
        return i;

    }
}
