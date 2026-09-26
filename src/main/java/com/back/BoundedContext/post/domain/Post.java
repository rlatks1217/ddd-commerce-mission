package com.back.BoundedContext.post.domain;

import com.back.global.entity.BaseEntity;
import com.back.global.entity.BaseGeneratedInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "POST_POST")
@Getter
@NoArgsConstructor
public class Post extends BaseGeneratedInfo {
    @ManyToOne(fetch = LAZY)
    private PostMember author;
    private String title;
    private String content;

    public Post(PostMember author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
