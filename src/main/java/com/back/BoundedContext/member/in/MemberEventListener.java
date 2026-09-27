package com.back.boundedContext.member.in;

import com.back.boundedContext.member.app.MemberFacade;
import com.back.shared.post.event.CreatePostCommentEvent;
import com.back.shared.post.event.CreatePostEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Component
@RequiredArgsConstructor
public class MemberEventListener {
    private final MemberFacade memberFacade;

    @TransactionalEventListener
    @Transactional(propagation = REQUIRES_NEW)
    public void handle(CreatePostEvent event) {
        memberFacade.increaseActivityScore(event.getPost().getAuthorId(), 3);
    }

    @TransactionalEventListener
    @Transactional(propagation = REQUIRES_NEW)
    public void handle(CreatePostCommentEvent event) {
        memberFacade.increaseActivityScore(event.getPostComment().getAuthorId(), 1);
    }
}
