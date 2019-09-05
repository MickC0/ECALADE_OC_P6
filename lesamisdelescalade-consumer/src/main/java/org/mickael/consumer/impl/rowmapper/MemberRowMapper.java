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
        member.setBirthDate(resultSet.getTimestamp("birthdate"));
        member.setGender(resultSet.getString("gender"));
        member.setEmail(resultSet.getString("email"));
        member.setPassword(resultSet.getString("password"));
        member.setMember(resultSet.getBoolean("is_member"));
        member.setAdmin(resultSet.getBoolean("is_admin"));

        return member;
    }
}
