package com.diacom.diacom.repository;

import com.diacom.diacom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String userLogin);
    Boolean existsByLogin(String userLogin);
    Boolean existsByPhoneNumber(Long phoneNumber);
}
