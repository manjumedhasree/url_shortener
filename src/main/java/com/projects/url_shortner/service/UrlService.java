package com.projects.url_shortner.service;

import com.projects.url_shortner.entity.url;
import com.projects.url_shortner.repository.url_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private url_repository repository;

    private static final String BASE62 =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generateShortUrl(String originalUrl){

        url url = new url();
        url.setOriginalUrl(originalUrl);

        url saved = repository.save(url);

        String shortCode;
        do {
            shortCode = encode(saved.getId() + System.nanoTime());
        } while(repository.findByShortCode(shortCode).isPresent());

        saved.setShortCode(shortCode);
        repository.save(saved);

        return "http://localhost:8080/r/" + shortCode;
    }

    public String getOriginalUrl(String shortCode){

        return repository.findByShortCode(shortCode)
                .map(url -> {
                    url.setClicks(url.getClicks() + 1);
                    repository.save(url);
                    return url.getOriginalUrl();
                })
                .orElse("URL not found");
    }

    private String encode(long num){
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            sb.append(BASE62.charAt((int)(num % 62)));
            num /= 62;
        }

        return sb.reverse().toString();
    }
}
