package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.CommentDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.model.bean.Comment;

import java.util.List;

public class CommentDaoImpl extends AbstractDataSourceImpl implements CommentDao {

    @Override
    public Comment createComment(Comment comment) {
        return null;
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
