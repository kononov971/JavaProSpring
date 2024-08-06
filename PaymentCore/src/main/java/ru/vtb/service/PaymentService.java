package ru.vtb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.vtb.config.properties.PaymentsProperties;
import ru.vtb.dto.ProductDTO;
import ru.vtb.exception.PaymentException;
import ru.vtb.exception.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class PaymentService {

    private final RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate, PaymentsProperties paymentProperties) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDTO> getProductsByUser(long userId) {
        return Arrays.asList(restTemplate.getForObject("?userId=" + userId, ProductDTO[].class));
    }

    public ProductDTO getProduct(long id) {
        try {
            return restTemplate.getForObject("/" + id, ProductDTO.class);
        } catch (Exception e) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
    }

    public ProductDTO execute(long id, BigDecimal paymentSum) {
        try {
            return restTemplate.postForObject("/payment/" + id, paymentSum, ProductDTO.class);

        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == 404) {
                throw new ProductNotFoundException("Product with id " + id + " not found");
            } else if (e.getStatusCode().value() == 400) {
                throw new PaymentException("Payment decline, product has insufficient balance");
            } else {
                throw e;
            }
        }
    }
}
