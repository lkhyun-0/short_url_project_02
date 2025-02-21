package com.example.short_url_project_02.domain.surl.controller;


import com.example.short_url_project_02.domain.member.member.entity.Member;
import com.example.short_url_project_02.global.exceptions.GlobalException;
import com.example.short_url_project_02.global.rq.Rq;
import com.example.short_url_project_02.global.rsData.RsData;
import com.example.short_url_project_02.domain.surl.entity.Surl;
import com.example.short_url_project_02.domain.surl.service.SurlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequiredArgsConstructor
@Slf4j
public class ShortUrlController {

    private final Rq rq;
    private final SurlService surlService;

    @GetMapping("/add")
    @ResponseBody
    public RsData<Surl> add(String body, String url) {

        Member member = rq.getMember(); // 현재 브라우저로 로그인 한 회원 정보

        return surlService.add(member, body, url);

    }

    @GetMapping("/s/{body}/**")
    @ResponseBody
    public RsData<Surl> add(
            @PathVariable String body,
            HttpServletRequest req
    ) {
        Member member = rq.getMember();

        String url = req.getRequestURI();

        if (req.getQueryString() != null) {
            url += "?" + req.getQueryString();
        }

        String[] urlBits = url.split("/", 4);

        url = urlBits[3];

        return surlService.add(member, body, url);
    }

    @GetMapping("/g/{id}")
    public String go(
            @PathVariable long id
    ) {
        Surl surl = surlService.findById(id).orElseThrow(GlobalException.E404::new);

        surlService.increaseCount(surl);

        return "redirect:" + surl.getUrl();
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Surl> getAll() {
        return surlService.findAll();
    }
}