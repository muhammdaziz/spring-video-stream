package com.example.appvideo.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class VideoService {

    private static final String SOURCE_PATH = "classpath:videos/%s.mp4";

    private final ResourceLoader resourceLoader;

    public VideoService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Mono<Resource> getVideo(String title) {

        return Mono.fromSupplier(
                () -> resourceLoader.
                getResource(String.format(SOURCE_PATH, title)));
    }
}
