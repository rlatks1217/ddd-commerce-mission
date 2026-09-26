package com.back.BoundedContext.post.out;

import com.back.BoundedContext.post.domain.PostMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostMember, Integer> {
}
