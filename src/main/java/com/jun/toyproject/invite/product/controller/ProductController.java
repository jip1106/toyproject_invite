package com.jun.toyproject.invite.product.controller;

import com.jun.toyproject.invite.common.type.InviteType;
import com.jun.toyproject.invite.product.model.request.SltOptionRequest;
import com.jun.toyproject.invite.product.model.response.BaseOptionResponse;
import com.jun.toyproject.invite.product.model.response.SltOptionResponse;
import com.jun.toyproject.invite.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "products", description = "상품, 상품옵션 관련 API")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/option/{inviteType}")
    @Operation(summary = "기본옵션정보", description = "모바일 초대장을 만들때 초대장 타입에 따른 옵션들을 조회한다.")
    public List<BaseOptionResponse> getBaseOptions(@PathVariable("inviteType") InviteType inviteType){
        return productService.findByInviteType(inviteType);
    }

    @PostMapping("/option/saveSltOptions")
    @Operation(summary = "선택옵션정보", description = "사용자가 선택한 옵션을 저장한다.")
    public List<SltOptionResponse> saveSltOptions(@RequestBody @Valid SltOptionRequest sltRequest, @SessionAttribute("sMemberId") String sMemberId){
        log.info("sMemberId :: {} " , sMemberId);

        return productService.insertSltOptions(sltRequest,sMemberId);

    }


}
