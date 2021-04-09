package com.diacom.diacom.service;

import com.diacom.diacom.entity.ScheduleOfMedicine;
import com.diacom.diacom.entity.User;

import java.util.List;

public interface ScheduleMedicineService {
    List<ScheduleOfMedicine> getAllByUserId(Long userId);
    List<ScheduleOfMedicine> getAll();
    ScheduleOfMedicine getSMedicine(Long id);
    ScheduleOfMedicine addSMedicine(ScheduleOfMedicine scheduleOfMedicine);
    String deleteSMedicineById(Long id);
    String deleteSMedicineByUserId(Long userId);
}
