package ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserInfoResponse {
    private String userId;
    private String name;
    private String surname;
}
