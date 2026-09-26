package com.back.BoundedContext.post.domain;

import com.back.global.entity.BaseEntity;
import com.back.global.entity.BaseGeneratedInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "POST_POST")
@Getter
@NoArgsConstructor
public class Post extends BaseGeneratedInfo {
    // author(member)
    private String title;
    private String content;
}
