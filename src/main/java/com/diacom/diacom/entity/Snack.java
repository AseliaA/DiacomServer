package com.diacom.diacom.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Snack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    String drink;

    Calendar calendar;

    Time time;

    int calories;

    int glycemicIndex;

   // Snack(String name, Time time, )
}
