package ru.mail.kmikhailov.b.webfluxdemo.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PurchasedMaterial {
    private String id;
    private String name;
    private LocalDateTime purchaseDate;
}
