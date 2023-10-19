package ru.mail.kmikhailov.b.webfluxdemo.service;

import reactor.core.publisher.Mono;
import ru.mail.kmikhailov.b.webfluxdemo.controller.response.UserDataResponse;

public interface UserDataService {
    Mono<UserDataResponse> getUserData(String userId);
}
