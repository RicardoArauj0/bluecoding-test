package com.bluecoding.controller;

import com.bluecoding.model.MostAccessedURLs;
import com.bluecoding.service.URLShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class URLShortenerController {

    private final URLShortenerService urlService;

    @PostMapping
    public ResponseEntity<String> shortenerURL(@RequestBody String originalUrl) {
        return new ResponseEntity<>(urlService.getUrlShorted(originalUrl), HttpStatus.CREATED);
    }

    @GetMapping("/{short}")
    public ResponseEntity<String> getOriginalURL(@PathVariable("short") String shortUrl) {
        return ResponseEntity.ok(urlService.getOriginalUrl(shortUrl));
    }

    @GetMapping("/most-accessed")
    public ResponseEntity<List<MostAccessedURLs>> getMostAccessedURL() {
        return ResponseEntity.ok(urlService.getMostAccessedUrl());
    }
}
