package org.mickael.business.contract.manager;

import org.mickael.model.bean.Comment;

import java.util.List;

public interface CommentManager {

    void createComment(Comment comment);
    Comment findComment(Integer id);
    void updateComment(Comment comment);
    void deleteComment(Integer id);
    List<Comment> findAllComment ();
}
