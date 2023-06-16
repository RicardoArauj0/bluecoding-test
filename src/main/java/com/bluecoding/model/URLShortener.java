package com.bluecoding.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "URL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class URLShortener {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ORIGINAL_URL")
    private String originalUrl;

    @Column(name = "SHORT_URL")
    private String shortUrl;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ACCESSED")
    private Long accessed;
}
