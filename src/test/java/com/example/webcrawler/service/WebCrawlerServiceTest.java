package com.example.webcrawler.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.example.webcrawler.model.PageMetadata;

@ExtendWith(MockitoExtension.class)
public class WebCrawlerServiceTest {

    private WebCrawlerService webCrawlerService;

    @BeforeEach
    public void setUp() {
        webCrawlerService = new WebCrawlerService();
    }

    @Test
    public void testCrawl_Success() {
        String testUrl = "https://example.com";
        PageMetadata result = webCrawlerService.crawl(testUrl);
        
        assertNotNull(result);
        assertEquals(testUrl, result.getUrl());
    }

    @Test
    public void testCrawl_InvalidUrl() {
        assertThrows(RuntimeException.class, () -> {
            webCrawlerService.crawl("invalid-url");
        });
    }
}
