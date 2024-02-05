package com.jun.toyproject.invite.member.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jun.toyproject.invite.member.entity.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MemberDetailResponse {

    @Schema(description = "회원 아이디")
    private String memberId;

    @Schema(description = "회원 이름")
    private String name;

    @Schema(description = "가입 일자")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    @Schema(description = "메세지")
    private String message;


    public MemberDetailResponse(String memberId, String name, LocalDateTime createdAt, String message) {
        this.memberId = memberId;
        this.name = name;
        this.createdAt = createdAt;
        this.message = message;
    }

    public static MemberDetailResponse of(Member member, String message){
        return new MemberDetailResponse(member.getMemberId(), member.getName(),
                member.getCreatedAt(), message);
    }
}
