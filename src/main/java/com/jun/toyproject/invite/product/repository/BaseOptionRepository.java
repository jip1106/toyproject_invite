package com.jun.toyproject.invite.product.repository;

import com.jun.toyproject.invite.common.type.InviteType;
import com.jun.toyproject.invite.product.entity.BaseOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseOptionRepository extends JpaRepository<BaseOption,Long> {
    List<BaseOption> findByInviteType(InviteType inviteType);
    List<BaseOption> findByInviteTypeOrderByPriorityAsc(InviteType inviteType);

}
