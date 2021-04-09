package com.diacom.diacom.repository;

import com.diacom.diacom.entity.FoodSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodScheduleRepository
        extends JpaRepository<FoodSchedule, Long> {
}
