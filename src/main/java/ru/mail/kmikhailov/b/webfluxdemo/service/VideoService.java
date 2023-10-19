package ru.mail.kmikhailov.b.webfluxdemo.service;

import reactor.core.publisher.Flux;
import ru.mail.kmikhailov.b.webfluxdemo.controller.request.AdvertisingVideoRequest;

public interface VideoService {
    Flux<byte[]> getVideo(AdvertisingVideoRequest request);
}
