package com.back.boundedContext.post.app;

import com.back.boundedContext.post.domain.Post;
import com.back.boundedContext.post.domain.PostComment;
import com.back.boundedContext.post.domain.PostMember;
import com.back.global.response.RsData;
import com.back.shared.post.event.CreatePostCommentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCommentWriteUseCase {
    private final ApplicationEventPublisher eventPublisher;

    public RsData<PostComment> addComment(Post post, PostMember author, String comment) {
        PostComment postComment = post.addComment(author, comment);
        eventPublisher.publishEvent(new CreatePostCommentEvent(postComment.toDto()));
        return new RsData<>("201-1", "댓글 작성 성공", postComment);
    }
}
