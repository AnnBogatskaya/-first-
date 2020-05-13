package com.bogatskaya.app.service;

import java.util.List;

import com.bogatskaya.app.domain.user.UserProfile;


public interface UserProfileService {

    List<UserProfile> findAll();

    UserProfile findOne(Long id);

    void save(UserProfile userProfile);

    void update(Long id, UserProfile userProfile);

    void delete(UserProfile userProfile);
}
