//package com.diacom.diacom.configuration;
//
//import com.diacom.diacom.entity.User;
//import com.diacom.diacom.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Optional;
//
//@Service
//public class UserDetailsService
//        implements org.springframework.security.core.userdetails.UserDetailsService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String userLogin)
//            throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByLogin(userLogin);
//
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userLogin));
//
//        return user.map(com.diacom.diacom.configuration.UserDetails::new).get();
//
//    }
//}
