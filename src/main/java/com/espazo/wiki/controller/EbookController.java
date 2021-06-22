package com.espazo.wiki.controller;

import com.espazo.wiki.domain.Ebook;
import com.espazo.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("list")
    public List<Ebook> list() {
        return ebookService.list();
    }
}
