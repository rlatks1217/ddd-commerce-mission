package com.back.BoundedContext.post.out;

import com.back.BoundedContext.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
