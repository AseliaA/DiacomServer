package com.diacom.diacom.bootstrap;

import com.diacom.diacom.entity.*;
import com.diacom.diacom.repository.FoodScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FoodScheduleBootStrap implements CommandLineRunner {

    @Autowired
    FoodScheduleRepository foodScheduleRepository;

    @Override
    public void run(String... args) throws Exception {
        FoodSchedule food1 = FoodSchedule.builder()
                .userId(1L)
                .breakfast(Breakfast.builder()
                        .name("omlet").build())
                .lunch(Lunch.builder()
                        .name("omlet2").build())
                .dinner(Dinner.builder()
                        .name("omlet3").build())
                .snack(Snack.builder().name("snack").build()).build();
        foodScheduleRepository.save(food1);


        //        ArrayList<Snack> snacks = new ArrayList<>();
        //        snacks.add(Snack.builder().name("ice-cream").build());


        //TODO Find a solution for Set<Snacks>
    }
}
