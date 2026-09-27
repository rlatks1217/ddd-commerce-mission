package com.back.shared.member.event;

import com.back.boundedContext.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
public class MemberModifiedEvent {
    private final MemberDto member;
}
