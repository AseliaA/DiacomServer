package com.diacom.diacom.bootstrap;

import com.diacom.diacom.entity.ScheduleOfMedicine;
import com.diacom.diacom.enums.DayOfTheWeek;
import com.diacom.diacom.enums.HowManyTimes;
import com.diacom.diacom.repository.ScheduleMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MedicineScheduleBootStrap implements CommandLineRunner {


    @Autowired
    ScheduleMedicineRepository scheduleMedicineRepository;

    @Override
    public void run(String... args) throws Exception {

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
    }
}
