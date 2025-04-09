package com.example.project.config;

import com.example.project.repository.TriangleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("no-db") // Only used in no-db profile
public class NoDBConfig {

    @Bean
    public TriangleRepository triangleRepository() {
        return new TriangleRepository() {
            // Optional: override methods if ShapeService uses any
            // For now, it'll be a no-op stub
        };
    }
}

