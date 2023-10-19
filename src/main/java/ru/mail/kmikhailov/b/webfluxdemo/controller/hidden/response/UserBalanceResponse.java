package ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserBalanceResponse {
    private String userId;
    private BigDecimal balance;
}
