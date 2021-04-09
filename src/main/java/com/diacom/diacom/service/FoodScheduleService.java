package com.diacom.diacom.service;

import com.diacom.diacom.entity.FoodSchedule;

import java.util.List;

public interface FoodScheduleService {
    List<FoodSchedule> getAll();
    FoodSchedule getFoodSById(Long id);
    List<FoodSchedule> getAllByUserId(Long userId);
    FoodSchedule addFoodS(FoodSchedule foodSchedule);
    String deleteAllFoodSByUserId(Long userId);
    String deleteFoodSById(Long id);
    String deleteAll();

}
