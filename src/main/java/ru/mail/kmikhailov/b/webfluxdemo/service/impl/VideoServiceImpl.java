package ru.mail.kmikhailov.b.webfluxdemo.service.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.mail.kmikhailov.b.webfluxdemo.controller.request.AdvertisingVideoRequest;
import ru.mail.kmikhailov.b.webfluxdemo.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {
    @Override
    public Flux<byte[]> getVideo(AdvertisingVideoRequest request) {
        return Flux.empty();
    }
}
