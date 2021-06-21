package com.espazo.wiki.controller;

import com.espazo.wiki.domain.Demo;
import com.espazo.wiki.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("list2")
    public List<Demo> list() {
        return demoService.list();
    }
}
