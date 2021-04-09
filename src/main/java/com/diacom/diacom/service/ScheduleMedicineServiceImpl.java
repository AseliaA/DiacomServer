package com.diacom.diacom.service;

import com.diacom.diacom.entity.ScheduleOfMedicine;
import com.diacom.diacom.repository.ScheduleMedicineRepository;
import com.diacom.diacom.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ScheduleMedicineServiceImpl implements ScheduleMedicineService{

    ScheduleMedicineRepository scheduleMedicineRepository;
    UserRepository userRepository;

    @Override
    public List<ScheduleOfMedicine> getAll(){
        return scheduleMedicineRepository.findAll();
    }

    @Override
    public List<ScheduleOfMedicine> getAllByUserId(Long userId) {
       return scheduleMedicineRepository.findAll().stream().filter
                (x->x.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleOfMedicine getSMedicine(Long id) {
        return scheduleMedicineRepository.findById(id).get();
    }

    @Override
    public ScheduleOfMedicine addSMedicine(ScheduleOfMedicine scheduleOfMedicine) {
        return scheduleMedicineRepository.save(scheduleOfMedicine);
    }

    @Override
    public String deleteSMedicineById(Long id) {
        scheduleMedicineRepository.deleteById(id);
        return null;
    }

    @Override
    public String deleteSMedicineByUserId(Long userId){

        scheduleMedicineRepository.deleteAll(scheduleMedicineRepository.findAll().stream().filter
                (x->x.getUserId().equals(userId))
                .collect(Collectors.toList()));
        return "Everything must worked";
    }
}
