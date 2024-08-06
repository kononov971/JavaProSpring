package ru.vtb.service;

import org.springframework.stereotype.Service;
import ru.vtb.dao.UserDAO;
import ru.vtb.model.User;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User createUser(String name) {
        return userDAO.save(new User(name));
    }

    public boolean deleteUser(long id) {
        return userDAO.delete(id);
    }

    public User updateUser(User user) {
        return userDAO.update(user);
    }

    public User findOne(long id) {
        return userDAO.get(id).orElse(null);
    }

    public List<User> findAll() {
        return userDAO.getAll();
    }
}
