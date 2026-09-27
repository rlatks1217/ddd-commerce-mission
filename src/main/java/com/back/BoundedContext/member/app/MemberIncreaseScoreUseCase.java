package com.back.boundedContext.member.app;

import com.back.boundedContext.member.domain.Member;
import com.back.shared.member.event.MemberModifiedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberIncreaseScoreUseCase {
    private final ApplicationEventPublisher eventPublisher;

    public void increaseActivityScore(Member member, int amount) {
        member.increaseActivityScore(amount);
        eventPublisher.publishEvent(new MemberModifiedEvent(member.toDto()));
    }
}
