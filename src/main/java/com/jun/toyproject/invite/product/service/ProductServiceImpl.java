package com.jun.toyproject.invite.product.service;

import com.jun.toyproject.invite.common.exception.InviteException;
import com.jun.toyproject.invite.common.type.InviteType;
import com.jun.toyproject.invite.product.entity.BaseOption;
import com.jun.toyproject.invite.product.model.response.BaseOptionResponse;
import com.jun.toyproject.invite.product.repository.BaseOptionRepository;
import com.jun.toyproject.invite.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final BaseOptionRepository baseOptionRepository;

    @Override
    public List<BaseOptionResponse> findByInviteType(InviteType inviteType) throws InviteException {

        List<BaseOption> baseOptions = baseOptionRepository.findByInviteTypeOrderByPriorityAsc(inviteType);

        /*
            List<BaseOptionResponse> rtnList = new ArrayList<>();
            for (BaseOption baseOption : baseOptions) {
                rtnList.add(BaseOptionResponse.from(baseOption));
            }
         */

        List<BaseOptionResponse> rtnList = baseOptions.stream()
                .map(BaseOptionResponse::from)
                .collect(Collectors.toList());

        if(rtnList.isEmpty()){
            throw new InviteException("옵션정보가 등록되어 있지 않습니다.", HttpStatus.NOT_FOUND);
        }

        return rtnList;
    }
}
