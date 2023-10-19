package ru.mail.kmikhailov.b.webfluxdemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.mail.kmikhailov.b.webfluxdemo.dto.PurchasedMaterial;
import ru.mail.kmikhailov.b.webfluxdemo.service.PurchasedMaterialClientService;

@Service
@RequiredArgsConstructor
public class PurchasedMaterialClientServiceImpl implements PurchasedMaterialClientService {
    private final WebClient remoteWebClient;

    @Override
    public Flux<PurchasedMaterial> getPurchasedMaterials(final String userId) {
        return remoteWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/emulate/external/purchasedMaterials")
                        .queryParam("userId", userId)
                        .build())
                .retrieve()
                .bodyToFlux(PurchasedMaterial.class);
    }
}
