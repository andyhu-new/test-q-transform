package com.example.webcrawler.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.example.webcrawler.model.PageMetadata;

@RunWith(MockitoJUnitRunner.class)
public class WebCrawlerServiceTest {

    @InjectMocks
    private WebCrawlerService webCrawlerService;

    @Test
    public void testCrawl_Success() {
        String testUrl = "https://example.com";
        PageMetadata result = webCrawlerService.crawl(testUrl);
        
        assertNotNull(result);
        assertEquals(testUrl, result.getUrl());
    }

    @Test(expected = RuntimeException.class)
    public void testCrawl_InvalidUrl() {
        webCrawlerService.crawl("invalid-url");
    }
}
