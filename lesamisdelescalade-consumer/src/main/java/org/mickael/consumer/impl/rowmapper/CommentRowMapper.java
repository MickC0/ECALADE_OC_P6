package org.mickael.consumer.impl.rowmapper;

import org.mickael.consumer.impl.dao.ClimbingAreaDaoImpl;
import org.mickael.consumer.impl.dao.MemberDaoImpl;
import org.mickael.model.bean.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentRowMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Comment comment = new Comment();

        comment.setId(resultSet.getInt("id"));
        comment.setDescription(resultSet.getString("description"));
        comment.setCreationDate(resultSet.getTimestamp("creation_date"));
        comment.setUpdateDate(resultSet.getTimestamp("update_date"));

        //on appelle la dao de l'objet souhaité pour créer le bean member
        MemberDaoImpl memberDao = new MemberDaoImpl();
        comment.setMember(memberDao.findMember(resultSet.getInt("member_id")));
        ClimbingAreaDaoImpl climbingAreaDao = new ClimbingAreaDaoImpl();
        comment.setClimbingArea(climbingAreaDao.findClimbingArea(resultSet.getInt("climbingArea_id")));

        return comment;
    }
}
