package com.diacom.diacom.bootstrap;

import com.diacom.diacom.entity.*;
import com.diacom.diacom.enums.DayOfTheWeek;
import com.diacom.diacom.enums.Gender;
import com.diacom.diacom.enums.HowManyTimes;
import com.diacom.diacom.enums.SugarType;
import com.diacom.diacom.repository.FoodScheduleRepository;
import com.diacom.diacom.repository.ScheduleMedicineRepository;
import com.diacom.diacom.repository.UserRepository;
import com.diacom.diacom.repository.UserRoleRepository;
import com.diacom.diacom.service.FoodScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
public class MainBootstrap implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ScheduleMedicineRepository scheduleMedicineRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    FoodScheduleRepository foodScheduleRepository;

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = User.builder()
                .name("Sam Don")
                .age(18)
                .login("login")
                .password(passwordEncoder.encode("pass"))
                .phoneNumberOrEmail(1234567891L)
                .gender(Gender.Female)
                .sugarType(SugarType.firstSugarType)
                .height(1.75f)
                .weight(75)
                .nameOfDoctorOfCase("Alex Smith")
                .build();

        User user2 = User.builder()
                .name("Alex")
                .age(20)
                .login("login1")
                .password("pass2")
                .phoneNumberOrEmail(12345678923L)
                .gender(Gender.Male)
                .sugarType(SugarType.secondSugarType)
                .height(1.75f)
                .weight(75)
                .nameOfDoctorOfCase("Alex Smith")
                .build();

        userRepository.save(user);
        UserRole userRole = UserRole.builder()
                .roleName("USER")
                .user(user)
                .build();
        userRoleRepository.save(userRole);

        userRepository.save(user);
        UserRole userRole2 = UserRole.builder()
                .roleName("USER")
                .user(user2)
                .build();
        userRepository.save(user2);

        ScheduleOfMedicine schedule = ScheduleOfMedicine.builder()
                .name("Ibuphen")
                .doctor("Me")
                .howManyTimes(HowManyTimes.onePerDay)
                .dayOfTheWeeks(DayOfTheWeek.EveryDay)
                .notes("after food")
                .userId(1L)
                .build();

        scheduleMedicineRepository.save(schedule);

        ScheduleOfMedicine schedule1 = ScheduleOfMedicine.builder()
                .name("12")
                .dayOfTheWeeks(DayOfTheWeek.EveryDay)
                .howManyTimes(HowManyTimes.onePerDay)
                .userId(1L)
                .build();
        scheduleMedicineRepository.save(schedule1);

        ArrayList<Snack> snacks = new ArrayList<>();
        snacks.add(Snack.builder().name("ice-cream").build());
        FoodSchedule food1 = FoodSchedule.builder()
                .userId(user.getId())
                .breakfast(Breakfast.builder()
                        .name("omlet").build())
                .lunch(Lunch.builder()
                        .name("omlet2").build())
                .dinner(Dinner.builder()
                .name("omlet3").build())
                .snacks(snacks).build();
        foodScheduleRepository.save(food1);

        //TODO Find a solution for Set<Snacks>
    }
}
