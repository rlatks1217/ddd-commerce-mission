package com.back.BoundedContext.member.in;

import com.back.BoundedContext.member.app.MemberFacade;
import com.back.BoundedContext.member.domain.Member;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class MemberDataInit {
    private final MemberDataInit self;
    private final MemberFacade memberFacade;

    public MemberDataInit(
            @Lazy MemberDataInit self,
            MemberFacade memberFacade
    ) {
        this.self = self;
        this.memberFacade = memberFacade;
    }

    @Bean
    @Order(1)
    public ApplicationRunner memberDataInitApplicationRunner() {
        return args -> {
            self.makeBaseMembers();
        };
    }

    @Transactional
    public void makeBaseMembers() {
        if (memberFacade.count() > 0) return;
        
        Member system = memberFacade.join("system", "1234", "system").getData();
        Member holding = memberFacade.join("holding", "1234", "system").getData();
        Member admin = memberFacade.join("admin", "1234", "system").getData();
        Member user1 = memberFacade.join("user1", "1234", "system").getData();
        Member user2 = memberFacade.join("user2", "1234", "system").getData();
        Member user3 = memberFacade.join("user3", "1234", "system").getData();
    }
}
