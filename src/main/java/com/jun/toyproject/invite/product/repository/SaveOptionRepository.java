package com.jun.toyproject.invite.product.repository;

import com.jun.toyproject.invite.member.entity.Member;
import com.jun.toyproject.invite.product.entity.SaveOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SaveOptionRepository extends JpaRepository<SaveOption, Long> {
    List<SaveOption> findByMember(Member member);
}
