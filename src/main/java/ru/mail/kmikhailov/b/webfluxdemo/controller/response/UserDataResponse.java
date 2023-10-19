package ru.mail.kmikhailov.b.webfluxdemo.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDataResponse {
    public static final UserDataResponse NULL = UserDataResponse.builder().build();
    private String userId;
    private String userName;
    private String userSurname;
    private BigDecimal balance;
    private List<UserDataMaterial> purchasedMaterials;
}
