package com.bogatskaya.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bogatskaya.app.domain.user.UserProfile;
import com.bogatskaya.app.repository.UserProfileRepository;
import com.bogatskaya.app.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserProfileServiceImpl.class);

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile findOne(Long id) {
        return null;
    }

    @Override
    public void save(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }

    @Override
    public void update(Long id, UserProfile userProfile) {

    }

    @Override
    public void delete(UserProfile userProfile) {
    }
}
