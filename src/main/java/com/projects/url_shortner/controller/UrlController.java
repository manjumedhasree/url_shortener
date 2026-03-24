package com.projects.url_shortner.controller;
import com.projects.url_shortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
@RestController
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String originalUrl){
        return service.generateShortUrl(originalUrl);
    }

    @GetMapping("/r/{code}")
    public ResponseEntity<?> redirect(@PathVariable String code){

        String originalUrl = service.getOriginalUrl(code);

        if (originalUrl.equals("URL not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("URL not found");
        }

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}