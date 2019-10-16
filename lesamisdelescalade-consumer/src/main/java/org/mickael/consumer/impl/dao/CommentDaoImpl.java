package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.CommentDao;
import org.mickael.consumer.impl.AbstractDao;
import org.mickael.consumer.impl.rowmapper.CommentRowMapper;
import org.mickael.model.bean.Comment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Types;
import java.util.List;

public class CommentDaoImpl extends AbstractDao implements CommentDao {

    @Override
    public void createComment(Comment comment) {
        String sql = "INSERT INTO public.comment (member_id, climbingArea_id, description, creation_date, update_date)"
                             + "VALUES (:memberId, :climbingAreaId, :description, :creationDate, :updateDate)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", comment.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("climbingAreaIdId", comment.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("description", comment.getDescription(), Types.VARCHAR);
        parameterSource.addValue("creationDate", comment.getCreationDate(), Types.TIMESTAMP);
        parameterSource.addValue("updateDate", comment.getUpdateDate(), Types.TIMESTAMP);

        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    @Override
    public Comment findCommentByMember(Integer id) {

        String sql = "SELECT * FROM public.comment WHERE member_id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        CommentRowMapper commentRowMapper = new CommentRowMapper();
        Comment comment = getNamedParameterJdbcTemplate().queryForObject(sql, parameterSource, commentRowMapper);

        return comment;
    }
    
    @Override
    public Comment findCommentByClimbingArea(Integer id){
        
        String sql = "SELECT * FROM public.comment WHERE climbingArea_id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        CommentRowMapper commentRowMapper = new CommentRowMapper();
        Comment comment = getNamedParameterJdbcTemplate().queryForObject(sql, parameterSource, commentRowMapper);

        return comment;
    }

    @Override
    public void updateComment(Comment comment) {
        String sql = "UPDATE public.comment SET "
                             + "member_id = :memberId, "
                             + "climbingArea_id = :climbingAreaId, "
                             + "description = :description, "
                             + "creation_date = :creationDate, "
                             + "update_date = :updateDate "
                             + "WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", comment.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("climbingAreaId", comment.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("description", comment.getDescription(), Types.VARCHAR);
        parameterSource.addValue("creationDate", comment.getCreationDate(), Types.TIMESTAMP);
        parameterSource.addValue("updateDate", comment.getUpdateDate(), Types.TIMESTAMP);;

        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public void deleteComment(Integer id) {
        String sql = "DELETE FROM public.comment WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public List<Comment> findAllComment() {
        String sql = "SELECT * FROM public.comment";
        CommentRowMapper commentRowMapper = new CommentRowMapper();
        List<Comment> commentList = getJdbcTemplate().query(sql, commentRowMapper);

        return commentList;
    }
    
    @Override
    public List<Comment> findAllCommentByMember(Integer id){
        String sql = "SELECT * FROM public.comment WHERE member_id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        CommentRowMapper commentRowMapper = new CommentRowMapper();
        List<Comment> commentListByMember = getNamedParameterJdbcTemplate().query(sql, parameterSource, commentRowMapper);

        return commentListByMember;
    }
    
    @Override
    public List<Comment> findAllCommentByClimbingArea(Integer id){
        String sql = "SELECT * FROM public.comment WHERE climbingarea_id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        CommentRowMapper commentRowMapper = new CommentRowMapper();
        List<Comment> commentListByClimbingArea = getNamedParameterJdbcTemplate().query(sql, parameterSource, commentRowMapper);

        return commentListByClimbingArea;
    }
}
