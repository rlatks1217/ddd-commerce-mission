package com.back.boundedContext.member.app;

import com.back.boundedContext.member.domain.Member;
import com.back.boundedContext.member.out.MemberRepository;
import com.back.global.response.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberJoinUseCase memberJoinUseCase;
    private final MemberRepository memberRepository;
    private final MemberIncreaseScoreUseCase memberIncreaseScoreUseCase;
    private final MemberGetTipUseCase memberGetTipUseCase;

    @Transactional
    public RsData<Member> join(String username, String password, String nickname) {
        return memberJoinUseCase.join(username, password, nickname);
    }

    @Transactional
    public long count() {
        return memberRepository.count();
    }

    public Optional<Member> findById(int id) {
        return memberRepository.findById(id);
    }

    @Transactional
    public void increaseActivityScore(int id, int amount) {
        Member member = memberRepository.findById(id).get();
        memberIncreaseScoreUseCase.increaseActivityScore(member, amount);
    }

    public String getRandomSecureTip() {
        return memberGetTipUseCase.getRandomSecureTip();
    }
}
