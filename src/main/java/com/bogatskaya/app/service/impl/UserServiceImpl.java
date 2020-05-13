package com.bogatskaya.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bogatskaya.app.domain.user.User;
import com.bogatskaya.app.dto.LoginDTO;
import com.bogatskaya.app.exception.AlreadyExistException;
import com.bogatskaya.app.exception.NotFoundException;
import com.bogatskaya.app.repository.UserRepository;
import com.bogatskaya.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        for(User u : userRepository.findAll()){
            if(u.getId().equals(id)){
                return u;
            }
        }
        LOGGER.error("No user with id: {}",id);
        throw new NotFoundException("No such user");
    }

    @Override
    public User findByLogin(final String login) {
        for(User u : userRepository.findAll()){
            if(u.getEmail().equals(login)){
                return u;
            }
        }
        LOGGER.error("There is no user with login: {}",login);
        throw new NotFoundException("No such user");
    }

    @Override
    public void saveUser(User user) {
        if(!isExist(user)) {
            userRepository.save(user);
            LOGGER.info("Save user to db!");
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean isExist(User user) {
        for(User u : userRepository.findAll()){
            if(u.getEmail().equals(user.getEmail()) ||
                    u.getLogin().equalsIgnoreCase(user.getLogin())){

                LOGGER.error("User already exist with that login or email");
                throw new AlreadyExistException("User already exist with that login or email");
            }
        }
        return false;
    }

    @Override
    public User validateUser(LoginDTO loginDTO) {
        for(User u : userRepository.findAll()){
            if(u.getLogin().equalsIgnoreCase(loginDTO.getUserName())
                    && u.getPassword().equalsIgnoreCase(loginDTO.getPassword())){
                    return u;
            }
        }
        LOGGER.error("No user with that login and password");
        return null;
    }

}
