package org.mickael.consumer.contract.dao;

import org.mickael.model.bean.Member;

import java.util.List;

public interface MemberDao {

    Member createMember(Member member);
    Member findMember(Integer id);
    void updateMember(Member member);
    void deleteMember(Integer id);
    List<Member> findAllMember ();
}
