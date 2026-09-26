package com.back.BoundedContext.post.out;

import com.back.BoundedContext.post.domain.PostMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostMemberRepository extends JpaRepository<PostMember, Integer> {
    Optional<PostMember> findByUsername(String username);
}
