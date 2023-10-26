package ru.mail.kmikhailov.b.webfluxdemo.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import ru.mail.kmikhailov.b.webfluxdemo.dto.PurchasedMaterial;

import java.net.URI;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PurchasedMaterialClientServiceImplTest {
    @Mock
    private WebClient remoteWebClient;
    @InjectMocks
    private PurchasedMaterialClientServiceImpl serviceUnderTest;

    @Mock
    private WebClient.RequestHeadersUriSpec requestSpec;
    @Mock
    private WebClient.ResponseSpec responseSpec;
    @Captor
    private ArgumentCaptor<Function<UriBuilder, URI>> uriCaptor;


    @Test
    void getPurchasedMaterials() {
        // given
        when(remoteWebClient.get()).thenReturn(requestSpec);
        when(requestSpec.uri(isA(Function.class))).thenReturn(requestSpec);
        when(requestSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToFlux(isA(Class.class))).thenReturn(Flux.just(
                PurchasedMaterial.builder().id("id1").name("material 1").build(),
                PurchasedMaterial.builder().id("id2").name("material 2").build(),
                PurchasedMaterial.builder().id("id3").name("material 3").build()
        ));

        // when
        StepVerifier.create(serviceUnderTest.getPurchasedMaterials("userId"))
                .thenAwait()
                .assertNext(material-> assertEquals("id1", material.getId()))
                .assertNext(material-> assertEquals("id2", material.getId()))
                .assertNext(material-> assertEquals("id3", material.getId()))
                .expectComplete()
                .verify();

        // then
        verify(remoteWebClient).get();
        verify(requestSpec).uri(uriCaptor.capture());
        verify(requestSpec).retrieve();
        verify(responseSpec).bodyToFlux(eq(PurchasedMaterial.class));

        UriBuilder builder = new DefaultUriBuilderFactory().builder();
        uriCaptor.getValue().apply(builder);

        assertEquals("/emulate/external/purchasedMaterials?userId=userId", builder.build().toString());
    }
}