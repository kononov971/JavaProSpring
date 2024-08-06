package ru.vtb.controller;

import org.springframework.web.bind.annotation.*;
import ru.vtb.dto.ProductDTO;
import ru.vtb.service.PaymentService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping()
    public List<ProductDTO> getProductsByUser(@RequestParam long userId) {
        return paymentService.getProductsByUser(userId);
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable long id) {
        return paymentService.getProduct(id);
    }

    @PostMapping("/{id}")
    public ProductDTO executePayment(@PathVariable long id, @RequestBody BigDecimal paymentSum) {
        return paymentService.execute(id, paymentSum);
    }

}
