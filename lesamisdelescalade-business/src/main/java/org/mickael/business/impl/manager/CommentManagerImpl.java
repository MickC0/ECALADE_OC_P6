package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.CommentManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.Comment;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class CommentManagerImpl extends AbstractManager implements CommentManager {
    @Override
    public void createComment(Comment comment) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getCommentDao().createComment(comment);
            }
        });

    }

    @Override
    public Comment findCommentByMember(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        Comment comment = transactionTemplate.execute(transactionStatus -> {
            Comment commentTransaction;
            commentTransaction = getDaoFactory().getCommentDao().findCommentByMember(id);
            return commentTransaction;
        });

        return comment;
    }

    @Override
    public Comment findCommentByClimbingArea(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        Comment comment = transactionTemplate.execute(transactionStatus -> {
            Comment commentTransaction;
            commentTransaction = getDaoFactory().getCommentDao().findCommentByClimbingArea(id);
            return commentTransaction;
        });

        return comment;
    }

    @Override
    public void updateComment(Comment comment) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getCommentDao().updateComment(comment);
            }
        });

    }

    @Override
    public void deleteComment(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getCommentDao().deleteComment(id);
            }
        });

    }

    @Override
    public List<Comment> findAllComment() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Comment> commentList = transactionTemplate.execute(transactionStatus -> {
            List<Comment> commentListTransaction = new ArrayList<>();
            commentListTransaction = getDaoFactory().getCommentDao().findAllComment();
            return  commentListTransaction;
        });

        return commentList;
    }

    @Override
    public List<Comment> findAllCommentByMember(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Comment> commentListMember = transactionTemplate.execute(transactionStatus -> {
            List<Comment> commentListTransaction = new ArrayList<>();
            commentListTransaction = getDaoFactory().getCommentDao().findAllCommentByMember(id);
            return  commentListTransaction;
        });

        return commentListMember;
    }

    @Override
    public List<Comment> findAllCommentByClimbingArea(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<Comment> commentListClimbingArea = transactionTemplate.execute(transactionStatus -> {
            List<Comment> commentListTransaction = new ArrayList<>();
            commentListTransaction = getDaoFactory().getCommentDao().findAllCommentByClimbingArea(id);
            return  commentListTransaction;
        });

        return commentListClimbingArea;
    }
}
