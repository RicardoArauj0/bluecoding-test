package com.bluecoding.repository;

import com.bluecoding.model.URLShortener;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface URLRepository extends CrudRepository<URLShortener, Long> {

    Optional<URLShortener> findByShortUrl(String shortUrl);

    Optional<List<URLShortener>> findByTitleIsNull();
}
