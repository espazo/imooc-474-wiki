package com.espazo.wiki.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

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
        return "hello, world\n";
    }
}
