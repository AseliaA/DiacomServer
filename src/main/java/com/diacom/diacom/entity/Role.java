package com.diacom.diacom.entity;

import com.diacom.diacom.enums.EnumRole;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", length = 20)
    EnumRole role;
}
