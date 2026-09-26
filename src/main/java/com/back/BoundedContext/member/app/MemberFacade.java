package com.back.BoundedContext.member.app;

import com.back.BoundedContext.member.domain.Member;
import com.back.BoundedContext.member.out.MemberRepository;
import com.back.global.response.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberJoinUseCase memberJoinUseCase;
    private final MemberRepository memberRepository;

    @Transactional
    public RsData<Member> join(String username, String password, String nickname) {
        return memberJoinUseCase.join(username, password, nickname);
    }

    public long count() {
        return memberRepository.count();
    }
}
