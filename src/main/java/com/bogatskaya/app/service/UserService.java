package com.bogatskaya.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bogatskaya.app.domain.user.User;
import com.bogatskaya.app.dto.LoginDTO;

@Service
public interface UserService {

    List<User> findAll();

    User findOne(Long id);

    User findByLogin(final String login);

    void saveUser(User user);

    void deleteUser(Long id);

    boolean isExist(User user);

    User validateUser(LoginDTO loginDTO);

}
