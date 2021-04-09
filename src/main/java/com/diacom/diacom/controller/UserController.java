package com.diacom.diacom.controller;


import com.diacom.diacom.entity.User;
import com.diacom.diacom.repository.UserRepository;
import com.diacom.diacom.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diacom")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class  UserController {
    UserService userService;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();


    @GetMapping(path = "/welcome")
    public String welcome(){
        return "Welcome to Diacom. We are happy to help you!";
    }


    @GetMapping(path = "/admin/all")
    public List<User> getUsers() {
        return userService.getAll();
    }

//    @GetMapping(path = "/user/getUser/{id}")
//    public User getUserById(@PathVariable Long id){
//        if(userService.getUserById(id).getLogin().equals(auth.getName())){
//            return userService.getUserById(id);
//        }return null;
//    }

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
