package com.back.boundedContext.post.domain;


import com.back.boundedContext.post.dto.PostCommentDto;
import com.back.global.entity.BaseGeneratedInfo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "POST_POST_COMMENT")
@NoArgsConstructor
@Getter
public class PostComment extends BaseGeneratedInfo {
    @ManyToOne(fetch = LAZY)
    private Post post;
    @ManyToOne(fetch = LAZY)
    private PostMember author;
    @Column(columnDefinition = "TEXT")
    private String content;

    public PostComment(Post post, PostMember author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }

    public PostCommentDto toDto() {
        return new PostCommentDto(
                getId(),
                getCreateDate(),
                getModifyDate(),
                post.getId(),
                author.getId(),
                author.getNickname(),
                content
        );
    }
}