package ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class PurchasedMaterial {
    private String id;
    private String name;
    private String orderId;
    private String paymentId;
    private LocalDateTime purchaseDate;
}
