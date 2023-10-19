package ru.mail.kmikhailov.b.webfluxdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.mail.kmikhailov.b.webfluxdemo.controller.request.AdvertisingVideoRequest;
import ru.mail.kmikhailov.b.webfluxdemo.controller.response.UserDataResponse;
import ru.mail.kmikhailov.b.webfluxdemo.service.UserDataService;
import ru.mail.kmikhailov.b.webfluxdemo.service.VideoService;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class BffController {
    private final UserDataService userDataService;
    private final VideoService videoService;

    @GetMapping("userData")
    @ResponseBody
    public Mono<UserDataResponse> getUserData(final @RequestParam String userId) {
        return userDataService.getUserData(userId);
    }

    @GetMapping("advertising")
    public Flux<byte[]> getAdvertisingVideo(final @RequestBody AdvertisingVideoRequest request) {
        return videoService.getVideo(request);
    }
}
