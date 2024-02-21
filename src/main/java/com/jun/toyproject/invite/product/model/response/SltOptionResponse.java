package com.jun.toyproject.invite.product.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jun.toyproject.invite.common.type.InviteType;
import com.jun.toyproject.invite.product.entity.SltOptions;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SltOptionResponse {

    @Schema(description = "선택한 옵션 저장 시퀀스")
    private Long sltSeq;

    @Schema(description = "선택한 옵션 저장 코드")
    private String sltCode;

    @Schema(description = "기본 옵션 코드")
    private String boCode;

    @Schema(description = "작성 날짜")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime saveCreateDate;

    public SltOptionResponse(SltOptions sltOption){
        this.sltSeq = sltOption.getSltSeq();
        this.sltCode = sltOption.getSltCode();
        this.boCode = sltOption.getBoCode();
        this.saveCreateDate = sltOption.getCreatedAt();

    }


    public static SltOptionResponse from(SltOptions sltOptions){

        return new SltOptionResponse(sltOptions);
    }




}
