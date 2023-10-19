package ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MaterialInfoRequest {
    private List<String> materialIds;
}
