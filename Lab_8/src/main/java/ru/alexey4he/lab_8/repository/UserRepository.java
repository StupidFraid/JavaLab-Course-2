package ru.alexey4he.lab_8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexey4he.lab_8.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
