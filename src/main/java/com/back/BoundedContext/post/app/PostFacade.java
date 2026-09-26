package com.back.BoundedContext.post.app;

import com.back.BoundedContext.member.domain.Member;
import com.back.BoundedContext.member.dto.MemberDto;
import com.back.BoundedContext.post.domain.Post;
import com.back.BoundedContext.post.domain.PostMember;
import com.back.BoundedContext.post.out.PostMemberRepository;
import com.back.BoundedContext.post.out.PostRepository;
import com.back.global.response.RsData;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.color.ICC_Profile;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostMemberRepository postMemberRepository;
    private final PostWriteUseCase postWriteUseCase;

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

        postMemberRepository.save(postMember);
    }

    public Optional<PostMember> findByUsername(String username) {
        return postMemberRepository.findByUsername(username);
    }

    public RsData<Post> write(PostMember author, String title, String content) {
        return postWriteUseCase.write(author, title, content);
    }
}
