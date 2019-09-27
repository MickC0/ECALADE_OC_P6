package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.Comment;

import java.util.List;

public interface CommentDao {

    void createComment(Comment comment);
    Comment findCommentByMember(Integer id);
    Comment findCommentByClimbingArea(Integer id);
    void updateComment(Comment comment);
    void deleteComment(Integer id);
    List<Comment> findAllComment ();
    List<Comment> findAllCommentByMember(Integer id);
    List<Comment> findAllCommentByClimbingArea(Integer id);
}
