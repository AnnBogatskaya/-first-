package com.bogatskaya.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bogatskaya.app.domain.user.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long>{
}
