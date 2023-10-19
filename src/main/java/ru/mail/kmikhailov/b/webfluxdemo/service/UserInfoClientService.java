package ru.mail.kmikhailov.b.webfluxdemo.service;

import reactor.core.publisher.Mono;
import ru.mail.kmikhailov.b.webfluxdemo.dto.UserInfoResponse;

public interface UserInfoClientService {
    Mono<UserInfoResponse> getUserInfo(String userId);
}
