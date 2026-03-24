package com.projects.url_shortner.repository;
import com.projects.url_shortner.entity.url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface url_repository extends JpaRepository<url,Long>{
    Optional<url> findByShortCode(String shortcode);
}
