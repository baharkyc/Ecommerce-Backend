package com.workintech.fizzystore.repository;


import com.workintech.fizzystore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.code = :authority")
    Optional<Role> findAuthority(@Param("authority") String authority);
}
