package com.diacom.diacom.entity;

import com.diacom.diacom.enums.Gender;
import com.diacom.diacom.enums.SugarType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


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

    @Column(name = "NameOfDoctor")
    String nameOfDoctor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String name, String login, String password,
                Long phoneNumberOrEmail, Integer age, Gender gender,
                SugarType sugarType, Float height, int weight,
                String nameOfDoctor) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.phoneNumberOrEmail = phoneNumberOrEmail;
        this.age = age;
        this.gender = gender;
        this.sugarType = sugarType;
        this.height = height;
        this.weight = weight;
        this.nameOfDoctor = nameOfDoctor;
    }
}
