package com.jun.toyproject.invite.product.service;

import com.jun.toyproject.invite.common.exception.InviteException;
import com.jun.toyproject.invite.common.type.InviteType;
import com.jun.toyproject.invite.product.model.response.BaseOptionResponse;

import java.util.List;

public interface ProductService {


    /***
     * 초대장 타입에 따른 옵션 리스트를 가져옴
     * @param inviteType
     * @return BaseOption list
     */
    List<BaseOptionResponse> findByInviteType(InviteType inviteType) throws InviteException;
}
