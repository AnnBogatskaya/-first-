package com.bogatskaya.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bogatskaya.app.domain.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
}
