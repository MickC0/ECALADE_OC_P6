package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.Member;

import java.util.List;

public interface MemberDao {

    void createMember(Member member);
    Member findMember(Integer id);
    Member findMemberByMail (String email);
    void updateMember(Member member);
    void deleteMember(Integer id);
    List<Member> findAllMember ();
}
