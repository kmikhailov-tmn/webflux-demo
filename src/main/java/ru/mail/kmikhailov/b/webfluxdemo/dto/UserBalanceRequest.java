package ru.mail.kmikhailov.b.webfluxdemo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserBalanceRequest {
    private String userId;
}
