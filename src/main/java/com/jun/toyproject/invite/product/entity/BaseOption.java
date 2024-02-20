package com.jun.toyproject.invite.product.entity;

import com.jun.toyproject.invite.common.entity.BaseEntity;
import com.jun.toyproject.invite.common.type.InviteType;
import com.jun.toyproject.invite.product.model.request.SltOptionRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseOption extends BaseEntity {

    public BaseOption(String code, Integer priority){
        this.code = code;
        this.priority = priority;
    }

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
