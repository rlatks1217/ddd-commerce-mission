package com.back.shared.post.event;

import com.back.boundedContext.post.dto.PostCommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreatePostCommentEvent {
    private final PostCommentDto postComment;
}
