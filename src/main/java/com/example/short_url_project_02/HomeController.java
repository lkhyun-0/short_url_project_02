package com.example.short_url_project_02;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Value("${custom.site.name}")
    private String siteName;
    @Value("${custom.secret.key:default-secret-key}") // 기본값 추가
    private String secretKey;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "main page!!!!!!!!!!!!!!!!" + siteName;

    }

    @GetMapping("/secretKey")
    public String secretKey() {
        return "Secret Key: " + secretKey;
    }
}
