package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.CommentDao;
import org.mickael.consumer.impl.AbstractDataSourceImpl;
import org.mickael.consumer.impl.rowmapper.CommentRowMapper;
import org.mickael.model.bean.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class CommentDaoImpl extends AbstractDataSourceImpl implements CommentDao {

    @Override
    public void createComment(Comment comment) {
        String sql = "INSERT INTO public.comment (member_id, climbingArea_id, description, creation_date, update_date)"
                             + "VALUES (:memberId, :climbingAreaId, :description, :creationDate, :updateDate)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", comment.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("climbingAreaIdId", comment.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("description", comment.getDescription(), Types.VARCHAR);
        parameterSource.addValue("creationDate", comment.getCreationDate(), Types.TIMESTAMP);
        parameterSource.addValue("updateDate", comment.getUpdateDate(), Types.TIMESTAMP);

        jdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public Comment findCommentByMember(Integer id) {

        String sql = "SELECT * FROM public.comment"
                             + " WHERE member_id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        CommentRowMapper commentRowMapper = new CommentRowMapper();
        Comment comment = jdbcTemplate.queryForObject(sql, commentRowMapper);

        return comment;
    }
    
    @Override
    Comment findCommentByClimbingArea(Integer id){
        
        String sql = "SELECT * FROM public.comment"
                             + " WHERE climbingArea_id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        CommentRowMapper commentRowMapper = new CommentRowMapper();
        Comment comment = jdbcTemplate.queryForObject(sql, commentRowMapper);

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

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("memberId", comment.getMember().getId(), Types.INTEGER);
        parameterSource.addValue("climbingAreaId", comment.getClimbingArea().getId(), Types.INTEGER);
        parameterSource.addValue("description", comment.getDescription(), Types.VARCHAR);
        parameterSource.addValue("creationDate", comment.getCreationDate(), Types.TIMESTAMP);
        parameterSource.addValue("updateDate", comment.getUpdateDate(), Types.TIMESTAMP);;

        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteComment(Integer id) {
        String sql = "DELETE FROM public.comment WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", id);
        jdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<Comment> findAllComment() {
        String sql = "SELECT * FROM public.comment";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        CommentRowMapper commentRowMapper = new CommentRowMapper();
        List<Comment> commentList = jdbcTemplate.query(sql, commentRowMapper);

        return commentList;
    }
    
    @Override
    List<Comment> findAllCommentByMember(){
        String sql = "SELECT * FROM public.comment"
                             + " WHERE member_id = " + id;        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        CommentRowMapper commentRowMapper = new CommentRowMapper();
        List<Comment> commentListByMember = jdbcTemplate.query(sql, commentRowMapper);

        return commentListByMember;
    }
    
    @Override
    List<Comment> findAllCommentByClimbingArea(){
        String sql = "SELECT * FROM public.comment"
                     + " WHERE climbingArea_id = " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        CommentRowMapper commentRowMapper = new CommentRowMapper();
        List<Comment> commentListByClimbingArea = jdbcTemplate.query(sql, commentRowMapper);

        return commentListByClimbingArea;
    }
}
