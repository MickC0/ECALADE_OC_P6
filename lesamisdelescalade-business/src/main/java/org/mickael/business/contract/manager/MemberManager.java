package org.mickael.business.contract.manager;

import org.mickael.model.bean.Member;

import java.util.List;

public interface MemberManager {
    void createMember(Member member);
    Member findMember(Integer id);
    void updateMember(Member member);
    void deleteMember(Integer id);
    List<Member> findAllMember ();
}
