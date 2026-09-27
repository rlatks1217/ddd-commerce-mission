package com.back.shared.post.event;

import com.back.boundedContext.post.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreatePostEvent {
    private PostDto post;
}
