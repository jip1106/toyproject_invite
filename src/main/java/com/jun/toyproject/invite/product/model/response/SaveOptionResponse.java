package com.jun.toyproject.invite.product.model.response;

import com.jun.toyproject.invite.product.entity.SaveOption;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveOptionResponse {

    @Schema(description = "저장 seq")
    private Long saveSeq;

    @Schema(description = "저장 코드")
    private String saveCode;

    @Schema(description = "최종 저장 여부")
    private boolean finalSave;

    public SaveOptionResponse(SaveOption saveOption) {
        saveSeq = saveOption.getSaveSeq();
        saveCode = saveOption.getSaveCode();
        finalSave = saveOption.isFinalSave();
    }

    public static SaveOptionResponse from(SaveOption saveOption){
        return new SaveOptionResponse(saveOption);
    }


}
