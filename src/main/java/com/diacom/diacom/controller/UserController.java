package com.diacom.diacom.controller;


import com.diacom.diacom.entity.User;
import com.diacom.diacom.service.UserService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diacom")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class  UserController {
    UserService userService;

//    @GetMapping(path = "/login")
//    public String login(){
//        return "You are on the right way!";
//    }

    @GetMapping(path = "/admin/all")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/user/getUser/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping(path = "/user/addUser")
    public User addUser(@RequestBody User user){
       return userService.addUser(user);
    }

    @DeleteMapping(path = "/user/deleteById/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return "You successfully deleted a user with ID:" + id;
    }
}
