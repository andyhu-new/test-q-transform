package com.example.webcrawler.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import com.example.webcrawler.model.PageMetadata;

@Service
public class WebCrawlerService {
    
    public PageMetadata crawl(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            String description = doc.select("meta[name=description]").first() != null 
                ? doc.select("meta[name=description]").first().attr("content")
                : "";
            
            return new PageMetadata(title, description, url);
        } catch (Exception e) {
            throw new RuntimeException("Failed to crawl URL: " + url, e);
        }
    }
}
