package com.back.BoundedContext.post.in;

import com.back.BoundedContext.post.app.PostFacade;
import com.back.shared.member.event.MemberJoinEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Component
@RequiredArgsConstructor
public class PostEventListener {
    private final PostFacade postFacade;

    @TransactionalEventListener
    @Transactional(propagation = REQUIRES_NEW)
    public void handle(MemberJoinEvent event) {
        postFacade.syncMember(event.getMember());
    }
}
