package com.example.webcrawler.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.webcrawler.model.PageMetadata;
import com.example.webcrawler.service.WebCrawlerService;

@RunWith(MockitoJUnitRunner.class)
public class WebCrawlerControllerTest {

    @Mock
    private WebCrawlerService webCrawlerService;

    @InjectMocks
    private WebCrawlerController webCrawlerController;

    @Test
    public void testCrawlPage_Success() {
        String testUrl = "https://example.com";
        PageMetadata expectedMetadata = new PageMetadata("Test Title", "Test Description", testUrl);
        
        when(webCrawlerService.crawl(testUrl)).thenReturn(expectedMetadata);
        
        PageMetadata result = webCrawlerController.crawlPage(testUrl);
        
        assertNotNull(result);
        assertEquals(expectedMetadata.getTitle(), result.getTitle());
        assertEquals(expectedMetadata.getDescription(), result.getDescription());
        assertEquals(expectedMetadata.getUrl(), result.getUrl());
        
        verify(webCrawlerService).crawl(testUrl);
    }

    @Test(expected = RuntimeException.class)
    public void testCrawlPage_ServiceThrowsException() {
        String testUrl = "invalid-url";
        when(webCrawlerService.crawl(testUrl)).thenThrow(new RuntimeException("Failed to crawl"));
        
        webCrawlerController.crawlPage(testUrl);
    }
}
