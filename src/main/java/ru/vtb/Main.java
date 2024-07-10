package ru.vtb;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vtb.config.AppConfiguration;
import ru.vtb.dao.UserDAO;
import ru.vtb.model.User;
import ru.vtb.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ru.vtb");

        UserService userService = context.getBean(UserService.class);

        User user1 = userService.createUser("user1");
        User user2 = userService.createUser("user2");
        User user3 = userService.createUser("user3");

        userService.findAll().forEach(System.out::println);

        userService.deleteUser(2);

        System.out.println();
        userService.findAll().forEach(System.out::println);

        user3.setUsername("user3.5");
        userService.updateUser(user3);

        System.out.println();
        System.out.println(userService.findOne(user3.getId()));
    }
}