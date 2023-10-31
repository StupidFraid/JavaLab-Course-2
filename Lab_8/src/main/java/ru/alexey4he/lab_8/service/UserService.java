package ru.alexey4he.lab_8.service;

import ru.alexey4he.lab_8.dto.UserDto;
import ru.alexey4he.lab_8.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
