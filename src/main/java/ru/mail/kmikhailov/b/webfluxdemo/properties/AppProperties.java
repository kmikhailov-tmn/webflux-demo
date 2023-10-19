package ru.mail.kmikhailov.b.webfluxdemo.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "application")
@Component
@Getter
@Setter
@NoArgsConstructor
public class AppProperties {
    private ExternalServiceProperties externalService;
}
