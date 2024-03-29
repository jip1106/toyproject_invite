package com.jun.toyproject.invite.product.entity;

import com.jun.toyproject.invite.common.entity.BaseEntity;
import com.jun.toyproject.invite.member.entity.Member;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SltOptions extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="slt_seq")
    private Long sltSeq;

    @Column(nullable = false)
    private String sltCode;

    private String boCode;

    private Integer priority;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="member_seq")
//    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="save_seq")
    private SaveOption saveOption;


    public SltOptions(String sltCode, String boCode, Integer priority , SaveOption saveOption) {
        this.sltCode = sltCode;
        this.boCode = boCode;
        this.priority = priority;
        this.saveOption = saveOption;
    }

    public static SltOptions of(String sltCode, String boCode, Integer priority, SaveOption saveOption){
        return new SltOptions(sltCode, boCode, priority,saveOption);
    }









}
