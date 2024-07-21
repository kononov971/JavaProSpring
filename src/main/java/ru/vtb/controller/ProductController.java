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
        Product product = productService.findOne(id);

        return productDTOFromProduct(product);
    }

    @GetMapping()
    public List<ProductDTO> getProductsByUser(@RequestParam long userId) {
        List<Product> products = productService.findByUser(userId);
        return products.stream().map(p -> productDTOFromProduct(p)).collect(Collectors.toList());
    }

    private ProductDTO productDTOFromProduct(Product product) {
        return  new ProductDTO(
                product.getId(),
                product.getAccountNum(),
                product.getBalance(),
                product.getType(),
                product.getUserId()
        );
    }
}
