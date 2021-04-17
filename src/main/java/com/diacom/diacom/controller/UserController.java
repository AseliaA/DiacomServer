package com.diacom.diacom.controller;


import com.diacom.diacom.entity.User;
import com.diacom.diacom.enums.Status;
import com.diacom.diacom.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diacom")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {
    UserService userService;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostMapping("/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userService.getAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userService.addUser(newUser);
        return Status.SUCCESS;
    }

//    @GetMapping("/user/login/{login}/{password}")
//    public Status loginUser(@RequestParam String login, @RequestParam String password) {
//        List<User> users = userService.getAll();
//        for (User other : users) {
//            if (other.getLogin().equals(login)
//                    && other.getPassword().equals(passwordEncoder.encode(password))) {
//                other.setLoggedIn(true);
//                return Status.SUCCESS;
//            }
//        }
//        return Status.FAILURE;
//    }

    @GetMapping(path = "/welcome")
    public String welcome() {
        return "Welcome to Diacom. We are happy to help you!";
    }


    @GetMapping(path = "/admin/all")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/user/getUser/{id}")
    public User getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PostMapping(path = "/user/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping(path = "/user/deleteById/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "You successfully deleted a user with ID:" + id;
    }
}
