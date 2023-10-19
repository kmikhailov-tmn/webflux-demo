package ru.mail.kmikhailov.b.webfluxdemo.controller.hidden;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.request.MaterialInfoRequest;
import ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.request.UserBalanceRequest;
import ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.request.UserInfoRequest;
import ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.response.MaterialInfo;
import ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.response.PurchasedMaterial;
import ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.response.UserBalanceResponse;
import ru.mail.kmikhailov.b.webfluxdemo.controller.hidden.response.UserInfoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("emulate/external")
@RequiredArgsConstructor
/*
  This is stub endpoints just for test.
  Suppose, every endpoint emulates different microservice.
 */
public class JustForTestController {

    @PostMapping("userInfo")
    @ResponseBody
    public Mono<UserInfoResponse> userInfo(final @RequestBody UserInfoRequest request) {
        return Mono.just(UserInfoResponse.builder()
                .userId(request.getUserId())
                .name("John")
                .surname("Doe")
                .build());
    }

    @PostMapping("userBalance")
    @ResponseBody
    public Mono<UserBalanceResponse> userBalance(final @RequestBody UserBalanceRequest request) {
        return Mono.just(UserBalanceResponse.builder()
                .userId(request.getUserId())
                .balance(new BigDecimal("30000.00"))
                .build());
    }

    @GetMapping("purchasedMaterials")
    @ResponseBody
    public Flux<PurchasedMaterial> purchasedMaterials(final @RequestParam String userId) {
        return Flux.fromIterable(List.of(
                PurchasedMaterial.builder()
                        .id("m1")
                        .name("Gadget #1")
                        .purchaseDate(LocalDateTime.of(2023, 1, 1, 12, 59))
                        .orderId("1111")
                        .paymentId("2221")
                        .build(),
                PurchasedMaterial.builder()
                        .id("m2")
                        .name("Gadget #2")
                        .purchaseDate(LocalDateTime.of(2023, 1, 2, 12, 59))
                        .orderId("1112")
                        .paymentId("2222")
                        .build(),
                PurchasedMaterial.builder()
                        .id("m3")
                        .name("Gadget #3")
                        .purchaseDate(LocalDateTime.of(2023, 1, 3, 12, 59))
                        .orderId("1113")
                        .paymentId("2223")
                        .build()
        )); // suppose we get it reactively from database repository or from DB & external microservice
    }

    @GetMapping("purchasedMaterials2")
    public Flux<PurchasedMaterial> purchasedMaterials2(final @RequestParam String userId) {
        return Flux.fromIterable(List.of(
                PurchasedMaterial.builder()
                        .id("m1")
                        .name("Gadget #1")
                        .purchaseDate(LocalDateTime.of(2023, 1, 1, 12, 59))
                        .orderId("1111")
                        .paymentId("2221")
                        .build(),
                PurchasedMaterial.builder()
                        .id("m2")
                        .name("Gadget #2")
                        .purchaseDate(LocalDateTime.of(2023, 1, 2, 12, 59))
                        .orderId("1112")
                        .paymentId("2222")
                        .build(),
                PurchasedMaterial.builder()
                        .id("m3")
                        .name("Gadget #3")
                        .purchaseDate(LocalDateTime.of(2023, 1, 3, 12, 59))
                        .orderId("1113")
                        .paymentId("2223")
                        .build()
        )); // suppose we get it reactively from database repository or from DB & external microservice
    }

    @GetMapping("materialInfo")
    @ResponseBody
    public Flux<MaterialInfo> materialInfo(final @RequestBody MaterialInfoRequest request) {
        return Flux.fromIterable(List.of(
                MaterialInfo.builder().id("m1").name("gadget #1").price(new BigDecimal("10.00")).build(),
                MaterialInfo.builder().id("m2").name("gadget #2").price(new BigDecimal("15.00")).build(),
                MaterialInfo.builder().id("m3").name("gadget #3").price(new BigDecimal("9.00")).build()
        ));
    }
}
