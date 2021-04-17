package com.diacom.diacom.bootstrap;

import com.diacom.diacom.entity.User;
import com.diacom.diacom.enums.Gender;
import com.diacom.diacom.enums.SugarType;
import com.diacom.diacom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserBootstrap implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//        User user = User.builder()
//                .name("Sam Don")
//                .age(18)
//                .login("login")
//                .password(passwordEncoder.encode("pass"))
//                .phoneNumberOrEmail(1234567891L)
//                .loggedIn(false)
//                .gender(Gender.Female)
//                .sugarType(SugarType.firstSugarType)
//                .height(1.75f)
//                .weight(75)
//                .nameOfDoctorOfCase("Alex Smith")
//                .userRole("ROLE_USER")
//                .build();
//
//        User user2 = User.builder()
//                .name("Alex")
//                .age(20)
//                .login("login2")
//                .password(passwordEncoder.encode("pass2"))
//                .loggedIn(false)
//                .phoneNumberOrEmail(12345678923L)
//                .gender(Gender.Male)
//                .sugarType(SugarType.secondSugarType)
//                .height(1.75f)
//                .weight(75)
//                .nameOfDoctorOfCase("Alex Smith")
//                .userRole("ROLE_ADMIN")
//                .build();
//
//        userRepository.save(user);
//        userRepository.save(user2);

    }
}
