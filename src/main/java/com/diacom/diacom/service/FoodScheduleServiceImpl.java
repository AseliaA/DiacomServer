package com.diacom.diacom.service;

import com.diacom.diacom.entity.FoodSchedule;
import com.diacom.diacom.repository.FoodScheduleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FoodScheduleServiceImpl implements FoodScheduleService {

    FoodScheduleRepository foodScheduleRepository;

    @Override
    public List<FoodSchedule> getAll() {
        return foodScheduleRepository.findAll();
    }

    @Override
    public FoodSchedule getFoodSById(Long id) {
        return foodScheduleRepository.findById(id).get();
    }


    @Override
    public List<FoodSchedule> getAllByUserId(Long userId) {
        return foodScheduleRepository.findAll().stream()
                .filter(x -> x.getUserId()
                        .equals(userId)).collect(Collectors.toList());
    }

    @Override
    public FoodSchedule addFoodS(FoodSchedule foodSchedule) {
        return foodScheduleRepository.save(foodSchedule);
    }

    @Override
    public String deleteAllFoodSByUserId(Long userId) {
        foodScheduleRepository.deleteAll(foodScheduleRepository.findAll()
                .stream().filter(x -> x.getUserId().equals(userId))
                .collect(Collectors.toList()));

        return "Everything must worked. All Food Schedules by User ID: " + userId + " were deleted";
    }

    @Override
    public String deleteFoodSById(Long id) {
        foodScheduleRepository.deleteById(id);
        return "Food Schedule by ID: " + id + " was deleted";
    }

    @Override
    public String deleteAll() {
        foodScheduleRepository.deleteAll();
        return "All Food Schedules were deleted";
    }
}
