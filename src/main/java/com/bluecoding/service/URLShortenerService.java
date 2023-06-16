package com.bluecoding.service;

import com.bluecoding.model.MostAccessedURLs;
import com.bluecoding.model.URLShortener;
import com.bluecoding.repository.URLRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class URLShortenerService {

    private final URLRepository urlRepository;

    public String getUrlShorted(String originalUrl) {
        //TODO Search the original URL on database before saving it
        String shortenedUrl = String.valueOf(originalUrl.hashCode());
        log.info("Shortened URL for " + originalUrl + " is " + shortenedUrl);
        URLShortener urlShortener = URLShortener.builder()
                .originalUrl(originalUrl)
                .shortUrl(shortenedUrl)
                .build();

        urlRepository.save(urlShortener);

        return shortenedUrl;
    }

    public String getOriginalUrl(String shortenedUrl) {
        URLShortener urlShortener = urlRepository.findByShortUrl(shortenedUrl).orElse(null);
        if (null == urlShortener) {
            return null;
        }

        return urlShortener.getOriginalUrl();
    }

    public List<MostAccessedURLs> getMostAccessedUrl() {

        return List.of(new MostAccessedURLs());
    }


}
