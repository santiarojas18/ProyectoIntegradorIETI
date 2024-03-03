package com.example.demo.service.user;

import com.example.demo.repository.user.User;
import com.example.demo.repository.user.UserDto;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    User save(UserDto userDto);

    User findById(String id);

    List<User> all();

    boolean deleteById(String id);

    User update(UserDto userDto, String userId);
}
