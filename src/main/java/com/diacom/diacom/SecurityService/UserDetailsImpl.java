package com.diacom.diacom.SecurityService;

import com.diacom.diacom.enums.Gender;
import com.diacom.diacom.enums.SugarType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long id;
    String name;
    String login;
    @JsonIgnore
    String password;
    Long phoneNumber;
    Integer age;
    Gender gender;
    SugarType sugarType;
    Float height;
    Integer weight;
    String nameOfDoctor;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String name,String login, String password, Long phoneNumber,
                           Integer age, Gender gender, SugarType sugarType,
                           Float height, Integer weight, String nameOfDoctor,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
        this.sugarType = sugarType;
        this.height = height;
        this.weight = weight;
        this.nameOfDoctor = nameOfDoctor;
        this.authorities = authorities;
    }




    public static UserDetailsImpl build(com.diacom.diacom.entity.User user){
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getPhoneNumberOrEmail(),
                user.getAge(),
                user.getGender(),
                user.getSugarType(),
                user.getHeight(),
                user.getWeight(),
                user.getNameOfDoctor(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return null;
    }


    public Long getPhoneNumber() {
        return phoneNumber;
    }


    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }


    public SugarType getSugarType() {
        return sugarType;
    }

    public Float getHeight() {
        return height;
    }


    public Integer getWeight() {
        return weight;
    }


    public String getNameOfDoctor() {
        return nameOfDoctor;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
