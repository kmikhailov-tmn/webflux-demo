package ru.mail.kmikhailov.b.webfluxdemo.service;

import reactor.core.publisher.Mono;
import ru.mail.kmikhailov.b.webfluxdemo.dto.UserBalanceResponse;

public interface UserBalanceClientService {
    Mono<? extends UserBalanceResponse> getUserBalance(String userId);
}
