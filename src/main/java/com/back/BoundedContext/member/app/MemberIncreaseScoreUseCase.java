package com.back.boundedContext.member.app;

import com.back.boundedContext.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberIncreaseScoreUseCase {

    public void increaseActivityScore(Member member, int amount) {
        member.increaseActivityScore(amount);
    }
}
