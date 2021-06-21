package com.espazo.wiki.controller;

import com.espazo.wiki.domain.Test;
import com.espazo.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private TestService testService;

    /**
     * GET, POST, PUT, DELETE
     *
     * /user?1
     * /user/1
     */
//    @PostMapping
//    @PutMapping
//    @DeleteMapping
//    @RequestMapping(value="/user/1", method = RequestMethod.GET)
//    @RequestMapping(vlaue="/user/1", method = RequestMethod.DELETE)
    @GetMapping("/hello")
    public String hello() {
        return "hello interface GET " + testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "hello interface POST, " + name;
    }

    @GetMapping("/test/list")
    public List<Test> list() {
        return testService.list();
    }
}
