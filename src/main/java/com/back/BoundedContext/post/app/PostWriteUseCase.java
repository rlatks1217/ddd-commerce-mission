package com.back.BoundedContext.post.app;

import com.back.BoundedContext.post.domain.Post;
import com.back.BoundedContext.post.domain.PostMember;
import com.back.BoundedContext.post.out.PostRepository;
import com.back.global.response.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostWriteUseCase {
    private final PostRepository postRepository;

    public RsData<Post> write(PostMember author, String title, String content) {
        Post post = postRepository.save(new Post(author, title, content));
        return new RsData<Post>("200-1", "글 생성완료", post);
    }
}
