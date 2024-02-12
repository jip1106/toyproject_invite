package com.jun.toyproject.invite.product.entity;

import com.jun.toyproject.invite.common.entity.BaseEntity;
import com.jun.toyproject.invite.common.type.InviteType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseOption extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "bo_seq")
    private Long boSeq;

    @Column(name="bo_code", unique = true, nullable = false)
    private String code;

    private String name;

    @Column(name = "dup_check")
    private boolean dupCheck;

    @Enumerated(EnumType.STRING)
    private InviteType inviteType;

    private Integer priority;

    @Lob
    private String description;


}
