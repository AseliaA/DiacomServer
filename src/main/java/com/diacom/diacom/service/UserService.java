package com.diacom.diacom.service;

import com.diacom.diacom.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    User getUserById(Long id);
    User addUser(User user);
    String deleteUserById(Long id);
}
