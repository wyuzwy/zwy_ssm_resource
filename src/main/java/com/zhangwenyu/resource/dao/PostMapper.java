package com.zhangwenyu.resource.dao;

import com.zhangwenyu.resource.bean.Post;
import com.zhangwenyu.resource.bean.PostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostMapper {
    long countByExample(PostExample example);

    long countByCondition(Post post);

    int deleteByExample(PostExample example);

    int deleteByPrimaryKey(Integer postId);

    int insert(Post record);

    int insertSelective(Post record);

    //根据标题、用户类型进行模糊查找
    List<Post> selectPostByConditions(Post post);

    List<Post> selectByExample(PostExample example);

    Post selectByPrimaryKey(Integer postId);

    //查询帖子时带有评论信息
    Post selectByPrimaryKeyWithComment(Integer postId);

    //查询所有帖子时带有用户信息
    List<Post> selectByExampleWithUser(PostExample example);

    int updateByExampleSelective(@Param("record") Post record, @Param("example") PostExample example);

    int updateByExample(@Param("record") Post record, @Param("example") PostExample example);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}