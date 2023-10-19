package ru.mail.kmikhailov.b.webfluxdemo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.mail.kmikhailov.b.webfluxdemo.controller.response.UserDataMaterial;
import ru.mail.kmikhailov.b.webfluxdemo.controller.response.UserDataResponse;
import ru.mail.kmikhailov.b.webfluxdemo.dto.PurchasedMaterial;
import ru.mail.kmikhailov.b.webfluxdemo.exception.CriticalUserDataError;
import ru.mail.kmikhailov.b.webfluxdemo.service.PurchasedMaterialClientService;
import ru.mail.kmikhailov.b.webfluxdemo.service.UserBalanceClientService;
import ru.mail.kmikhailov.b.webfluxdemo.service.UserDataService;
import ru.mail.kmikhailov.b.webfluxdemo.service.UserInfoClientService;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDataServiceImpl implements UserDataService {
    private final UserInfoClientService userInfoClientService;
    private final UserBalanceClientService userBalanceClientService;
    private final PurchasedMaterialClientService purchasedMaterialService;

    @Override
    public Mono<UserDataResponse> getUserData(String userId) {
        Mono<List<PurchasedMaterial>> materialsMono = purchasedMaterialService.getPurchasedMaterials(userId)
                .collectList()
                .defaultIfEmpty(Collections.emptyList());
        return Mono.zip(userInfoClientService.getUserInfo(userId),
                        userBalanceClientService.getUserBalance(userId),
                        materialsMono)
                .map(tuple -> {
                    var userInfo = tuple.getT1();
                    var userBalance = tuple.getT2();
                    List<PurchasedMaterial> materials = tuple.getT3();
                    return UserDataResponse.builder()
                            .userId(userId)
                            .userName(userInfo.getName())
                            .userSurname(userInfo.getSurname())
                            .balance(userBalance.getBalance())
                            .purchasedMaterials(buildMaterials(materials))
                            .build();
                }).onErrorResume(throwable -> {
                    if (isErrorCritical(throwable)) {
                        log.error("some error, just return empty result");
                        return Mono.just(UserDataResponse.NULL);
                    }
                    log.error("critical error, giving up", throwable);
                    return Mono.error(new CriticalUserDataError(throwable));
                });
    }

    private boolean isErrorCritical(Throwable throwable) {
        return false;
    }

    private List<UserDataMaterial> buildMaterials(List<PurchasedMaterial> materials) {
        return materials.stream()
                .map(material -> UserDataMaterial.builder()
                        .id(material.getId())
                        .name(material.getName())
                        .purchaseDate(material.getPurchaseDate())
                        .build())
                .toList();
    }

    Mono<UserDataResponse> getUserData1(String userId) {
        return userInfoClientService.getUserInfo(userId)
                .flatMap(userInfo -> userBalanceClientService.getUserBalance(userId)
                        .map(userBalance -> UserDataResponse.builder()
                                .userId(userId)
                                .userName(userInfo.getName())
                                .userSurname(userInfo.getSurname())
                                .balance(userBalance.getBalance())
                                .build())
                );
    }

    Mono<UserDataResponse> getUserDataVariant2(String userId) {
        return userInfoClientService.getUserInfo(userId)
                .zipWith(userBalanceClientService.getUserBalance(userId), (info, balance) -> UserDataResponse.builder()
                        .userId(userId)
                        .userName(info.getName())
                        .userSurname(info.getSurname())
                        .balance(balance.getBalance())
                        .build()
                );
    }

    Mono<UserDataResponse> getUserDataVariant3(String userId) {
        return Mono.zip(userInfoClientService.getUserInfo(userId), userBalanceClientService.getUserBalance(userId),
                (info, balance) -> UserDataResponse.builder()
                        .userId(userId)
                        .userName(info.getName())
                        .userSurname(info.getSurname())
                        .balance(balance.getBalance())
                        .build()
        );
    }

    Mono<UserDataResponse> getUserDataVariant4(String userId) {
        return Mono.zip(userInfoClientService.getUserInfo(userId), userBalanceClientService.getUserBalance(userId))
                .map(tuple -> {
                    var info = tuple.getT1();
                    var balance = tuple.getT2();
                    return UserDataResponse.builder()
                            .userId(userId)
                            .userName(info.getName())
                            .userSurname(info.getSurname())
                            .balance(balance.getBalance())
                            .build();
                });
    }
}
