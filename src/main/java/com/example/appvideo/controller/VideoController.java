package com.example.appvideo.controller;

import com.example.appvideo.service.VideoService;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @RequestMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@RequestHeader("Range") String range,@PathVariable String title){
        return videoService.getVideo(title);
    }
}
