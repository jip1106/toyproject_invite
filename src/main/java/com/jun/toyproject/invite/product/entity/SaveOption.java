package com.jun.toyproject.invite.product.entity;

import com.jun.toyproject.invite.common.entity.BaseEntity;
import com.jun.toyproject.invite.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveOption extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="save_seq")
    private Long saveSeq;

    private String saveCode;

    private boolean finalSave;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_seq")
    private Member member;

    @OneToMany(mappedBy = "saveOption")
    private List<SltOptions> sltOptionLists = new ArrayList<>();

    public SaveOption(String saveCode, boolean finalSave, Member member) {
        this.saveCode = saveCode;
        this.finalSave = finalSave;
        this.member = member;
    }

    public static SaveOption of(String saveCode, boolean finalSave, Member member){
        return new SaveOption(saveCode, finalSave, member);

    }
}
