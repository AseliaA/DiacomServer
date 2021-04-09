package com.diacom.diacom.repository;

import com.diacom.diacom.entity.ScheduleOfMedicine;
import com.diacom.diacom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleMedicineRepository extends
        JpaRepository<ScheduleOfMedicine, Long> {
}
