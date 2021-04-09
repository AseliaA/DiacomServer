package com.diacom.diacom.service;

import com.diacom.diacom.entity.User;
import com.diacom.diacom.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return this.userRepository.findById(id).get();
    }


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return null;
    }

}
