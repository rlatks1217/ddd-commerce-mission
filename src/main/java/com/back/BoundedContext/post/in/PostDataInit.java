package com.back.BoundedContext.post.in;

import com.back.BoundedContext.member.app.MemberFacade;
import com.back.BoundedContext.member.domain.Member;
import com.back.BoundedContext.post.app.PostFacade;
import com.back.BoundedContext.post.domain.Post;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class PostDataInit {
    private final PostDataInit self;
    private final MemberFacade memberFacade;
    private final PostFacade postFacade;

    public PostDataInit(
            @Lazy PostDataInit self,
            MemberFacade memberFacade,
            PostFacade postFacade
    ) {
        this.self = self;
        this.memberFacade =memberFacade;
        this.postFacade = postFacade;
    }

    @Bean
    @Order(2)
    public ApplicationRunner postDataInitApplicationRunner() {
        return args -> {
            self.makeBasePosts();
        };
    }

    @Transactional
    public void makeBasePosts() {
//        Member user1 = memberFacade.findByUsername("user1").get();
//        Member user2 = memberFacade.findByUsername("user2").get();
//        Member user3 = memberFacade.findByUsername("user3").get();

//        Post post = postFacade.write(user1, "제목1", "댓글1").getData();

    }
}
