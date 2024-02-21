package com.jun.toyproject.invite.product.service;

import com.jun.toyproject.invite.common.code.CodeGenerator;
import com.jun.toyproject.invite.common.exception.InviteException;
import com.jun.toyproject.invite.common.type.InviteType;
import com.jun.toyproject.invite.member.entity.Member;
import com.jun.toyproject.invite.member.repository.MemberRepository;
import com.jun.toyproject.invite.product.entity.BaseOption;
import com.jun.toyproject.invite.product.entity.SaveOption;
import com.jun.toyproject.invite.product.entity.SltOptions;
import com.jun.toyproject.invite.product.model.request.SltOptionRequest;
import com.jun.toyproject.invite.product.model.response.BaseOptionResponse;
import com.jun.toyproject.invite.product.model.response.SaveOptionResponse;
import com.jun.toyproject.invite.product.model.response.SltOptionResponse;
import com.jun.toyproject.invite.product.repository.BaseOptionRepository;
import com.jun.toyproject.invite.product.repository.ProductRepository;
import com.jun.toyproject.invite.product.repository.SaveOptionRepository;
import com.jun.toyproject.invite.product.repository.SltOptionsRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final BaseOptionRepository baseOptionRepository;
    private final SltOptionsRepository sltOptionsRepository;
    private final SaveOptionRepository saveOptionRepository;

    private final MemberRepository memberRepository;

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

    @Transactional
    @Override
    public List<SltOptionResponse> insertSltOptions(SltOptionRequest sltOptionRequest, String sMemberId) throws InviteException {
        List<String> optionIds = sltOptionRequest.getOptionIds();
        List<Integer> priorities = sltOptionRequest.getPriorities();

        int size = optionIds.size();

        List<SltOptionResponse> rtnList = new ArrayList<>();
        List<SltOptions> optionsList = new ArrayList<>();

        String saveCode = CodeGenerator.generateWithPrefix("SAVE");

        Member findMember = memberRepository.findByMemberId(sMemberId)
                .orElseThrow(() -> new InviteException("로그인 상태가 끊어졌습니다.", HttpStatus.NOT_FOUND));


        SaveOption saveOption = saveOptionRepository.save(SaveOption.of(saveCode, false, findMember));

        for(int i=0; i<size; i++){
            optionsList.add(SltOptions.of(saveCode,optionIds.get(i), priorities.get(i), saveOption) );
        }

        sltOptionsRepository.saveAll(optionsList);


        return SltOptionResponse.from(optionsList);
    }

    @Override
    public List<SaveOptionResponse> chkSaveItem(String sMemberId) {
        return null;
    }
}
