package com.diacom.diacom.entity;

import com.diacom.diacom.enums.DayOfTheWeek;
import com.diacom.diacom.enums.HowManyTimes;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "scheduleOfFood")
public class FoodSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @JoinColumn(name = "user_id")
    Long userId;

    @OneToOne(cascade=CascadeType.ALL , targetEntity = Breakfast.class)
    @JoinColumn(name = "breakfast", nullable = false)
    Breakfast breakfast;

    @OneToOne(cascade=CascadeType.ALL , targetEntity = Lunch.class)
    @JoinColumn(name = "lunch", nullable = false)
    Lunch lunch;

    @OneToOne(cascade=CascadeType.ALL , targetEntity = Dinner.class)
    @JoinColumn(name = "dinner", nullable = false)
    Dinner dinner;

    @ManyToOne(cascade=CascadeType.ALL , targetEntity = Snack.class)
    @JoinColumn(name = "snacks")
    List<Snack> snacks;

    @Column(name = "notes")
    String notes;

}
