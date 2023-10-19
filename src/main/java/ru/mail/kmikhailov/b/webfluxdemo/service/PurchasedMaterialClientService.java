package ru.mail.kmikhailov.b.webfluxdemo.service;

import reactor.core.publisher.Flux;
import ru.mail.kmikhailov.b.webfluxdemo.dto.PurchasedMaterial;

public interface PurchasedMaterialClientService {
    Flux<PurchasedMaterial> getPurchasedMaterials(String userId);
}
