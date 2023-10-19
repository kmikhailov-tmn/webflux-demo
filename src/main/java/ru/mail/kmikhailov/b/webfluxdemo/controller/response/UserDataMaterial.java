package ru.mail.kmikhailov.b.webfluxdemo.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class UserDataMaterial {
    private String id;
    private String name;
    private LocalDateTime purchaseDate;
}
