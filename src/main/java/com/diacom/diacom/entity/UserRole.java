package com.diacom.diacom.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "role" , nullable = false,length = 100)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
