package ru.vtb.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "integrations.executors")
public class PaymentsProperties {

    private final RestTemplateProperties productsExecutorClient;

    public PaymentsProperties(RestTemplateProperties productsExecutorClient) {
        this.productsExecutorClient = productsExecutorClient;
    }

    public RestTemplateProperties getProductsExecutorClient() {
        return productsExecutorClient;
    }
}
