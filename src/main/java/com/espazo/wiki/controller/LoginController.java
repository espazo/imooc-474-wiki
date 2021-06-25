package com.espazo.wiki.controller;

import com.espazo.wiki.config.WikiApplication;
import com.espazo.wiki.domain.User;
import com.espazo.wiki.resp.CommonResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public CommonResp login(@RequestBody User req) {
        if (req.getAccount().equals("root") && req.getPassword().equals("root")) {
            WikiApplication.isLogin = true;
        } else {
            WikiApplication.isLogin = false;
        }
        CommonResp response = new CommonResp<>();
        response.setSuccess(WikiApplication.isLogin);
        return response;
    }
}
