package com.jun.toyproject.invite.member.repository;

import com.jun.toyproject.invite.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    Long countByMemberId(String memberId);

    Optional<Member> findByMemberSeqAndMemberId(Long memberSeq, String memberId);

    Optional<Member> findByMemberId(String memberId);

    Optional<Member> findByMemberIdAndPassword(String memberId, String password);


}
