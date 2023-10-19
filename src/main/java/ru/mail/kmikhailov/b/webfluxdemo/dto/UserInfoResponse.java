package ru.mail.kmikhailov.b.webfluxdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserInfoResponse {
    private String userId;
    private String name;
    private String surname;
}
