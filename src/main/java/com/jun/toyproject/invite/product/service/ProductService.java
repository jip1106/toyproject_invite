package com.jun.toyproject.invite.product.service;

import com.jun.toyproject.invite.common.exception.InviteException;
import com.jun.toyproject.invite.common.type.InviteType;
import com.jun.toyproject.invite.product.model.request.SltOptionRequest;
import com.jun.toyproject.invite.product.model.response.BaseOptionResponse;
import com.jun.toyproject.invite.product.model.response.SaveOptionResponse;
import com.jun.toyproject.invite.product.model.response.SltOptionResponse;

import java.util.List;

public interface ProductService {


    /***
     * 초대장 타입에 따른 옵션 리스트를 가져옴
     * @param inviteType
     * @return BaseOption list
     */
    List<BaseOptionResponse> findByInviteType(InviteType inviteType) throws InviteException;

    /**
     * 사용자가 선택한 옵션을 저장
     */
    List<SltOptionResponse> insertSltOptions(SltOptionRequest sltOptionRequest,String sMemberId) throws InviteException;

    List<SaveOptionResponse> chkSaveItem(String sMemberId);
}
