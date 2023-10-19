package ru.mail.kmikhailov.b.webfluxdemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.mail.kmikhailov.b.webfluxdemo.dto.UserBalanceRequest;
import ru.mail.kmikhailov.b.webfluxdemo.dto.UserBalanceResponse;
import ru.mail.kmikhailov.b.webfluxdemo.service.UserBalanceClientService;

@Service
@RequiredArgsConstructor
public class UserBalanceClientServiceImpl implements UserBalanceClientService {
    private final WebClient remoteWebClient;

    @Override
    public Mono<? extends UserBalanceResponse> getUserBalance(String userId) {
        return remoteWebClient.post()
                .uri(uriBuilder -> uriBuilder.path("/emulate/external/userBalance")
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(buildUserBalanceRequest(userId)))
                .exchangeToMono(response -> response.bodyToMono(UserBalanceResponse.class));
    }

    private UserBalanceRequest buildUserBalanceRequest(String userId) {
        return new UserBalanceRequest(userId);
    }
}
