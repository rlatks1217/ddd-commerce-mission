package com.back.BoundedContext.post.app;

import com.back.BoundedContext.member.dto.MemberDto;
import com.back.BoundedContext.post.domain.PostMember;
import com.back.BoundedContext.post.out.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostRepository postRepository;

    @Transactional
    public void syncMember(MemberDto member) {
        PostMember postMember = new PostMember(
            member.getId(),
            member.getCreateDate(),
            member.getModifyDate(),
            member.getUsername(),
            "",
            member.getNickname(),
            member.getActivityScore()
        );

        postRepository.save(postMember);
    }
}
