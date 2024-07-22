package ru.vtb.service;

import org.springframework.stereotype.Service;
import ru.vtb.repository.ProductRepository;
import ru.vtb.dto.ProductDTO;
import ru.vtb.exception.ProductException;
import ru.vtb.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO findOne(long id) {
        Product product = productRepository.get(id).orElseThrow(() -> new ProductException("Product with id " + id + " not found"));

        return productDTOFromProduct(product);
    }

    public List<ProductDTO> findByUser(long userId) {
        return productRepository.getByUser(userId).stream().map(p -> productDTOFromProduct(p)).collect(Collectors.toList());
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
