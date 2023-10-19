package ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MaterialInfo {
    private String id;
    private String name;
    private String categoryId;
    private BigDecimal price;
}
