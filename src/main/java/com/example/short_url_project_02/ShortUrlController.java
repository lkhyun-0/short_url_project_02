package com.example.short_url_project_02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShortUrlController {       // 긴 url을 서버에 보냈을 때 url 길이를 줄여주는 메서드 만들거임

    private List<Surl> surl = new ArrayList<Surl>();
    @GetMapping("/add")
    @ResponseBody
    public String add(String url) {

        return "hello world";
    }

}
