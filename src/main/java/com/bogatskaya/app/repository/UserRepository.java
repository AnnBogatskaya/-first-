package com.bogatskaya.app.repository;

import java.util.Optional;

import com.bogatskaya.app.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByLogin(final String login);
}
