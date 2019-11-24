package org.mickael.consumer.impl.rowmapper;

import org.mickael.model.bean.Member;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<Member> {
    @Override
    public Member mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Member member = new Member();

        member.setId(resultSet.getInt("id"));
        member.setFirstName(resultSet.getString("first_name"));
        member.setLastName(resultSet.getString("last_name"));
        member.setPseudo(resultSet.getString("pseudo"));
        member.setGender(resultSet.getString("gender"));
        member.setEmail(resultSet.getString("email"));
        member.setPassword(resultSet.getString("password"));
        member.setRole(resultSet.getString("role"));
        member.setEnabled(resultSet.getBoolean("enabled"));
        //TODO SET guidebooklist
        /** new guidebookList
         * new commentList
         * new climbingAreaList
         */
        //member.setGuidebookList(resultSet.get);
        return member;
    }
}
