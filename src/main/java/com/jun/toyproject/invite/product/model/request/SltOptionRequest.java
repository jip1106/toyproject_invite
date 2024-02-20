package com.jun.toyproject.invite.product.model.request;

import com.jun.toyproject.invite.product.entity.BaseOption;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class SltOptionRequest {

    @Schema(description = "선택한 옵션 id")
    private List<String> optionIds;

    @Schema(description = "정렬순위")
    private List<Integer> priorities;

    @Builder
    public SltOptionRequest(List<String> optionIds, List<Integer> priorities){
        this.optionIds = optionIds;
        this.priorities = priorities;
    }
}
