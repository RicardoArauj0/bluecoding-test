package com.bluecoding.service;

import com.bluecoding.model.URLShortener;
import com.bluecoding.repository.URLRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@EnableAsync
@RequiredArgsConstructor
@Slf4j
public class URLTitleScheduler {

    private final URLRepository urlRepository;

    @Async
    @Scheduled(fixedRate = 5000)
    public void getTitlesFromURLScheduler() throws InterruptedException {
        log.info("Starting scheduler");
        List<URLShortener> urlShortenerList = urlRepository.findByTitleIsNull().orElse(null);


        if (null != urlShortenerList ) {
            log.info("URLs retrieved: " + urlShortenerList.size());
            urlShortenerList.forEach(url -> url.setTitle(getTitle(url.getOriginalUrl())));
            urlRepository.saveAll(urlShortenerList);
        }

    }

    private String getTitle(String url) {
        InputStream response = null;
        try {
            response = new URL(url).openStream();

            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            return responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>"));

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                response.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }


}
