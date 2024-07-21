package ru.vtb.dao;

import org.springframework.stereotype.Component;
import ru.vtb.model.Product;
import ru.vtb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAO {

    private final Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public Optional<Product> get(long id)  {
        String sql = "SELECT * FROM products WHERE id=?";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Product product = null;

            if (resultSet.next()) {
                product = new Product(
                        id,
                        resultSet.getLong("account_num"),
                        resultSet.getBigDecimal("balance"),
                        resultSet.getString("type"),
                        resultSet.getLong("user_id")
                        );
            }

            return Optional.ofNullable(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Product> getByUser(long userId)  {
        String sql = "SELECT * FROM products WHERE user_id=?";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getLong("id"),
                        resultSet.getLong("account_num"),
                        resultSet.getBigDecimal("balance"),
                        resultSet.getString("type"),
                        resultSet.getLong("user_id")
                ));
            }

            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
