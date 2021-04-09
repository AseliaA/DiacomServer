package com.diacom.diacom.controller;

import com.diacom.diacom.entity.FoodSchedule;
import com.diacom.diacom.service.FoodScheduleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diacom")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FoodScheduleController {

    FoodScheduleService foodScheduleService;

    @GetMapping(path = "/admin/allFoodS")
    public List<FoodSchedule> getAll(){
        return foodScheduleService.getAll();
    }
}
