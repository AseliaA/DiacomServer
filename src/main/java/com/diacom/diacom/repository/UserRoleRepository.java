package com.diacom.diacom.repository;

import com.diacom.diacom.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository
        extends JpaRepository<UserRole,Long> {
}
