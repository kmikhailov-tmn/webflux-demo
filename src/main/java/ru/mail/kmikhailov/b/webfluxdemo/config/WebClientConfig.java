package ru.mail.kmikhailov.b.webfluxdemo.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import ru.mail.kmikhailov.b.webfluxdemo.properties.AppProperties;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class WebClientConfig {
    private final AppProperties appProperties;

    @Bean
    public WebClient remoteWebClient(final WebClient.Builder builder) {
        return builder.filter((request, next) -> {
                    log.debug("Request {} to: {}", request.method(), request.url());
                    return next.exchange(request);
                })
                .baseUrl(appProperties.getExternalService().getBaseUrl())
                .build();
    }
}
