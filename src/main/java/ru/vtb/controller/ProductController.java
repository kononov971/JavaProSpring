package ru.vtb.controller;

import org.springframework.web.bind.annotation.*;
import ru.vtb.dto.ProductDTO;
import ru.vtb.model.Product;
import ru.vtb.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
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
        return productService.findByUser(userId);
    }

}
