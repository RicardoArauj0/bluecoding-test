package com.bluecoding.model;

import lombok.Data;

@Data
public class MostAccessedURLs {

    private String originalUrl;
    private String shortURL;
    private String title;
    private Long accessed;

}
