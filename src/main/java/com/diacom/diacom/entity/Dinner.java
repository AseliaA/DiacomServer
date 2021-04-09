package com.diacom.diacom.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Dinner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    String drink;

    int calories;

    int glycemicIndex;
}
