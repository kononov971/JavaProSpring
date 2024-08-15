package ru.vtb.service;

import org.springframework.stereotype.Service;
import ru.vtb.entity.User;
import ru.vtb.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User findOne(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
