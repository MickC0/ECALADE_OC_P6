package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.CommentManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.Comment;

import java.util.List;

public class CommentManagerImpl extends AbstractManager implements CommentManager {
    @Override
    public void createComment(Comment comment) {

    }

    @Override
    public Comment findComment(Integer id) {
        return null;
    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public void deleteComment(Integer id) {

    }

    @Override
    public List<Comment> findAllComment() {
        return null;
    }
}
