package com.diacom.diacom.entity;

import com.diacom.diacom.enums.Gender;
import com.diacom.diacom.enums.SugarType;
import lombok.*;
import org.springframework.context.annotation.Role;

import javax.persistence.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "login", nullable = false, unique = true)
    String login;

    @Column(name = "passwordd", nullable = false, length = 300)
    String password;

    @Column(name = "phoneNumberOrEmail", unique = true)
    Long phoneNumberOrEmail;

    @Column(name = "age", nullable = false)
    Integer age;

    @Column(name = "gender", nullable = false)
    Gender gender;

    @Column(name = "sugarType", nullable = false)
    SugarType sugarType;

    @Column(name = "height", nullable = false)
    Float height;

    @Column(name = "weight", nullable = false)
    int weight;

    @Column(name = "NameOfDoctorOfCase")
    String nameOfDoctorOfCase;

    @Column(name = "userRole")
    String userRole;
}
