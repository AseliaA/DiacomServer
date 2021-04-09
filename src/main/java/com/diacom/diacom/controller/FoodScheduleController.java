package com.diacom.diacom.controller;

import com.diacom.diacom.entity.FoodSchedule;
import com.diacom.diacom.service.FoodScheduleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diacom")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FoodScheduleController {

    FoodScheduleService foodScheduleService;

    @GetMapping(path = "/admin/allFoodS")
    public List<FoodSchedule> getAll() {
        return foodScheduleService.getAll();
    }

    @GetMapping(path = "/user/getFoodS/{foodId}")
    public FoodSchedule getByFoodId(@PathVariable Long foodId) {
        return foodScheduleService.getFoodSById(foodId);
    }

    @GetMapping(path = "/user/getFoodS/{userId}")
    public List<FoodSchedule> getAllByUserId(@PathVariable Long userId) {
        return foodScheduleService.getAllByUserId(userId);
    }

    @PostMapping(path = "/user/addFoodS")
    public FoodSchedule addFoodS(FoodSchedule foodSchedule) {
        return foodScheduleService.addFoodS(foodSchedule);
    }

    @DeleteMapping(path = "/user/deleteFoodSById/{foodId}")
    public String deleteFoodById(@PathVariable Long foodId) {
        foodScheduleService.deleteFoodSById(foodId);
        return "You have deleted FoodSchedule, id: " + foodId;
    }

    @DeleteMapping(path = "/user/deleteAllFoodSByUserId/{userId}")
    public String deleteAllByUserId(@PathVariable Long userId) {
        foodScheduleService.deleteAllFoodSByUserId(userId);
        return "You have deleted all FoodSchedules by userId" + userId;
    }

    @DeleteMapping(path = "/admin/deleteAllFoodS")
    public String deleteAllFoodS() {
        foodScheduleService.deleteAll();
        return "You have deleted all FoodSchedules";
    }
}
