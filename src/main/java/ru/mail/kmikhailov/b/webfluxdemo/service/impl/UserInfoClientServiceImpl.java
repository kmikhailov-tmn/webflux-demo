package ru.mail.kmikhailov.b.webfluxdemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.mail.kmikhailov.b.webfluxdemo.dto.UserInfoRequest;
import ru.mail.kmikhailov.b.webfluxdemo.dto.UserInfoResponse;
import ru.mail.kmikhailov.b.webfluxdemo.service.UserInfoClientService;

@Service
@RequiredArgsConstructor
public class UserInfoClientServiceImpl implements UserInfoClientService {
    private final WebClient remoteWebClient;

    @Override
    public Mono<UserInfoResponse> getUserInfo(final String userId) {
        return remoteWebClient.post()
                .uri(uriBuilder -> uriBuilder.path("/emulate/external/userInfo")
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(buildUserDataRequest(userId)))
                .exchangeToMono(response -> response.bodyToMono(UserInfoResponse.class));
    }

    private UserInfoRequest buildUserDataRequest(String userId) {
        return UserInfoRequest.builder()
                .userId(userId)
                .build();
    }
}
