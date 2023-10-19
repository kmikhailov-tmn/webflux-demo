package ru.mail.kmikhailov.b.webfluxdemo.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AdvertisingVideoRequest {
    private String userId;
    private int advertisingId;
}
