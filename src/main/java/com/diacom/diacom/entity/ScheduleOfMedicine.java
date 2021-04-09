package com.diacom.diacom.entity;

import com.diacom.diacom.enums.DayOfTheWeek;
import com.diacom.diacom.enums.HowManyTimes;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "scheduleOfMedicine")
public class ScheduleOfMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    //    @ManyToOne(cascade=CascadeType.MERGE, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    Long userId;

    @Column(name = "nameOfMedicine", nullable = false, unique = true)
    String name;

    @Column(name = "doctor")
    String doctor;

    @Column(name = "daysOfTheWeek", nullable = false)
    DayOfTheWeek dayOfTheWeeks;

    @Column(name = "howManyTimes", nullable = false)
    HowManyTimes howManyTimes;
    //TODO Set a notification for medicine schedule. Ask Ksenia or Sergei about it

    @Column(name = "notes")
    String notes;

}
