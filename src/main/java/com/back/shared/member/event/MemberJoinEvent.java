package com.back.shared.member.event;

import com.back.boundedContext.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberJoinEvent {
    private final MemberDto member;
}
