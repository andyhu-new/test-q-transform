package com.example.webcrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.webcrawler.model.PageMetadata;
import com.example.webcrawler.service.WebCrawlerService;

@RestController
public class WebCrawlerController {
    
    @Autowired
    private WebCrawlerService webCrawlerService;
    
    @GetMapping("/crawl")
    public PageMetadata crawlPage(@RequestParam String url) {
        return webCrawlerService.crawl(url);
    }
}
