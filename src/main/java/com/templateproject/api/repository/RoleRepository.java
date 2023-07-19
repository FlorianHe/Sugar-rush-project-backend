package com.templateproject.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templateproject.api.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByAuthority(String authority);
}
