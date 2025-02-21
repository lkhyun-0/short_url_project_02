package com.example.short_url_project_02.global.initData;

import com.example.short_url_project_02.domain.article.article.entity.Article;
import com.example.short_url_project_02.domain.article.article.service.ArticleService;
import com.example.short_url_project_02.domain.member.member.entity.Member;
import com.example.short_url_project_02.domain.member.member.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

//!prod == dev or test

@Profile("!prod")
@Configuration
@RequiredArgsConstructor
public class NotProd {
    @Lazy
    @Autowired
    private NotProd self;

    private final ArticleService articleService;
    private final MemberService memberService;

    @Bean
    @Order(4)
    public ApplicationRunner initDataProd() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1() {
        if (articleService.count() > 0) return;

        Member member1 = memberService.findByUsername("user1").get();
        Member member2 = memberService.findByUsername("user2").get();

        Article article1 = articleService.write(member1, "제목 1", "내용 1").getData();
        Article article2 = articleService.write(member1, "제목 2", "내용 2").getData();
        Article article3 = articleService.write(member2, "제목 3", "내용 3").getData();
        Article article4 = articleService.write(member2, "제목 4", "내용 4").getData();

    }
}