package ru.vtb.service;

import org.springframework.stereotype.Service;
import ru.vtb.entity.Product;
import ru.vtb.exception.PaymentException;
import ru.vtb.repository.ProductRepository;
import ru.vtb.dto.ProductDTO;
import ru.vtb.exception.ProductException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO findOne(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductException("Product with id " + id + " not found"));

        return productDTOFromProduct(product);
    }

    public List<ProductDTO> findByUserId(Long userId) {
        return productRepository.findByUserId(userId).stream().map(p -> productDTOFromProduct(p)).collect(Collectors.toList());
    }

    public ProductDTO executePayment(long id, BigDecimal paymentSum) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductException("Product with id " + id + " not found"));

        BigDecimal balance = product.getBalance();
        if (balance.compareTo(paymentSum) < 0) {
            throw new PaymentException("Payment decline, balance of product " + id + " is " + balance + ", payment is " + paymentSum);
        } else {
            balance = balance.subtract(paymentSum);
            product.setBalance(balance);
            productRepository.save(product);
        }

        return productDTOFromProduct(product);
    }

    private ProductDTO productDTOFromProduct(Product product) {
        return  new ProductDTO(
                product.getId(),
                product.getAccountNum(),
                product.getBalance(),
                product.getType(),
                product.getUser().getId()
        );
    }
}
