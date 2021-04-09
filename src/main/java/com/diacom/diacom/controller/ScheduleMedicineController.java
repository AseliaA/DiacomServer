package com.diacom.diacom.controller;

import com.diacom.diacom.entity.ScheduleOfMedicine;
import com.diacom.diacom.service.ScheduleMedicineService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diacom")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ScheduleMedicineController {
    ScheduleMedicineService scheduleMedicineService;

    @GetMapping(path = "/admin/allMedicineS")
    public List<ScheduleOfMedicine> getAll(){
        return scheduleMedicineService.getAll();
    }
    @GetMapping(path = "/user/scheduleMByUser/{userId}")
    public List<ScheduleOfMedicine> getAllScheduleM(@PathVariable Long userId){
        return scheduleMedicineService.getAllByUserId(userId);
    }

    @GetMapping(path = "/user/scheduleMById/{id}")
    public ScheduleOfMedicine getScheduleM(@PathVariable Long id){
        return scheduleMedicineService.getSMedicine(id);
    }


    @PostMapping(path = "/user/addScheduleM")
    public ScheduleOfMedicine addScheduleM(@RequestBody ScheduleOfMedicine scheduleOfMedicine){
        return scheduleMedicineService.addSMedicine(scheduleOfMedicine);
    }

    @DeleteMapping(path = "/user/deleteScheduleMById/{id}")
    public String deleteScheduleM(@PathVariable Long id){
        scheduleMedicineService.deleteSMedicineById(id);
        return "Everything is worked";
    }

    @DeleteMapping(path = "/user/deleteScheduleMByUserId/{userId}")
    public String deleteScheduleMByUser(@PathVariable Long userId){
        scheduleMedicineService.deleteSMedicineByUserId(userId);
        return null;
    }

}
