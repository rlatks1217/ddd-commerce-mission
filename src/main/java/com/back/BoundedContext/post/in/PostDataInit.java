package com.back.boundedContext.post.in;

import com.back.boundedContext.post.app.PostFacade;
import com.back.boundedContext.post.domain.Post;
import com.back.boundedContext.post.domain.PostMember;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class PostDataInit {
    private final PostDataInit self;
    private final PostFacade postFacade;

    public PostDataInit(
            @Lazy PostDataInit self,
            PostFacade postFacade
    ) {
        this.self = self;
        this.postFacade = postFacade;
    }

    @Bean
    @Order(2)
    public ApplicationRunner postDataInitApplicationRunner() {
        return args -> {
            self.makeBasePosts();
            self.makeBasePostComments();
        };
    }

    @Transactional
    public void makeBasePosts() {
        if (postFacade.count() > 0) return;

        PostMember user1 = postFacade.findByUsername("user1").get();
        PostMember user2 = postFacade.findByUsername("user2").get();
        PostMember user3 = postFacade.findByUsername("user3").get();

        Post post1 = postFacade.write(user1, "제목1", "내용1").getData();
        Post post2 = postFacade.write(user1, "제목2", "내용2").getData();
        Post post3 = postFacade.write(user1, "제목3", "내용3").getData();
        Post post4 = postFacade.write(user2, "제목4", "내용4").getData();
        Post post5 = postFacade.write(user2, "제목5", "내용5").getData();
        Post post6 = postFacade.write(user3, "제목6", "내용6").getData();
    }

    @Transactional
    public void makeBasePostComments() {
        PostMember user1 = postFacade.findByUsername("user1").get();
        PostMember user2 = postFacade.findByUsername("user2").get();
        PostMember user3 = postFacade.findByUsername("user3").get();

        Post post1 = postFacade.finById(1).get();
        Post post2 = postFacade.finById(2).get();
        Post post3 = postFacade.finById(3).get();
        Post post4 = postFacade.finById(4).get();
        Post post5 = postFacade.finById(5).get();
        Post post6 = postFacade.finById(6).get();

        if (post1.hasComments()) return;

        postFacade.addComment(post1, user1, "댓글1");
        postFacade.addComment(post1, user1, "댓글2");
        postFacade.addComment(post2, user2, "댓글3");
        postFacade.addComment(post2, user2, "댓글4");
        postFacade.addComment(post2, user2, "댓글5");
        postFacade.addComment(post3, user3, "댓글6");
        postFacade.addComment(post3, user3, "댓글7");
        postFacade.addComment(post3, user3, "댓글8");
    }
}
