package ru.vtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vtb.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
