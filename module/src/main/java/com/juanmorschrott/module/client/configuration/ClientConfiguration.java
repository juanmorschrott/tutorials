package com.juanmorschrott.module.client.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("module")
public class ClientConfiguration {
    private String url;
    private Integer port;
}
