package ru.mail.kmikhailov.b.webfluxdemo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PurchasedMaterial {
    private String id;
    private String name;
    private LocalDateTime purchaseDate;
}
