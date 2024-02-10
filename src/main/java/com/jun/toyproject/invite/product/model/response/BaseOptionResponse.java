package com.jun.toyproject.invite.product.model.response;

import com.jun.toyproject.invite.common.type.InviteType;
import com.jun.toyproject.invite.product.entity.BaseOption;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseOptionResponse {

    @Schema(description = "옵션 시퀀스")
    private Long boSeq;

    @Schema(description = "옵션 코드")
    private String code;

    @Schema(description = "명칭")
    private String name;

    @Schema(description = "타입")
    private InviteType inviteType;

    @Schema(description = "순서")
    private Integer priority;

    @Schema(description = "중복 가능 옵션")
    private boolean dupCheck;

    public static BaseOptionResponse from(BaseOption baseOption){
        return new BaseOptionResponse(
                baseOption.getBoSeq(),
                baseOption.getCode(),
                baseOption.getName(),
                baseOption.getInviteType(),
                baseOption.getPriority(),
                baseOption.isDupCheck()
        );
    }
}
