package ru.vtb.controller;

import org.springframework.web.bind.annotation.*;
import ru.vtb.dto.ProductDTO;
import ru.vtb.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable long id) {
        return productService.findOne(id);
    }

    @GetMapping()
    public List<ProductDTO> getProductsByUser(@RequestParam long userId) {
        return productService.findByUserId(userId);
    }

    @PostMapping("/payment/{id}")
    public ProductDTO executePayment(@PathVariable long id, @RequestBody BigDecimal paymentSum) {
        return productService.executePayment(id, paymentSum);
    }


}