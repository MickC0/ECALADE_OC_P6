package org.mickael.business.contract.manager;

import org.mickael.model.bean.Comment;

import java.util.List;

public interface CommentManager {

    void createComment(Comment comment);
    Comment findCommentByMember(Integer id);
    Comment findCommentByClimbingArea(Integer id);
    void updateComment(Comment comment);
    void deleteComment(Integer id);
    List<Comment> findAllComment ();
    List<Comment> findAllCommentByMember(Integer id);
    List<Comment> findAllCommentByClimbingArea(Integer id);
}
