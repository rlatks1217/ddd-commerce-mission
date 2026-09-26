package com.back.BoundedContext.member.app;

import com.back.BoundedContext.member.domain.Member;
import com.back.BoundedContext.member.out.MemberRepository;
import com.back.global.exception.DomainException;
import com.back.global.response.RsData;
import com.back.shared.member.event.MemberJoinEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberJoinUseCase {
    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher eventPublisher;

    public RsData<Member> join(String username, String password, String nickname) {
        memberRepository.findByUsername(username).ifPresent(m -> {
            throw new DomainException("409-1", "이미 존재하는 유저");
        });

        Member member = memberRepository.save(new Member(username, password, nickname));
        eventPublisher.publishEvent(new MemberJoinEvent(member.toDto()));
        return new RsData<Member>("201-1", "유저 생성 완료", member);
    }
}
