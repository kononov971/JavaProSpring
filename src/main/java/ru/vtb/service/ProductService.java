package ru.vtb.service;

import org.springframework.stereotype.Service;
import ru.vtb.dao.ProductDAO;
import ru.vtb.exception.ProductException;
import ru.vtb.model.Product;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product findOne(long id) {
        return productDAO.get(id).orElseThrow(() -> new ProductException("Product with id " + id + " not found"));
    }

    public List<Product> findByUser(long userId) {
        return productDAO.getByUser(userId);
    }
}
