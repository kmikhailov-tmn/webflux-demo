package ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserInfoRequest {
    private String userId;
}
