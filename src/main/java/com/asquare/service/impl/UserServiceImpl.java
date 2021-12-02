package com.asquare.service.impl;

import com.asquare.dto.UserDtailsDto;
import com.asquare.entity.UserEntity;
import com.asquare.repository.UserRepository;
import com.asquare.service.UserService;
import com.asquare.shared.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Utils utils;

    @Override
    public UserDtailsDto createUser(UserDtailsDto user) {
        //preparing persistence object for table
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userEntity.setEncryptedPassword("encryption");
        userEntity.setUserId(utils.generateId(20));
        //saving user to table
        UserEntity savedUser = userRepository.save(userEntity);
        //preparing return object
        UserDtailsDto userDtailsDto = new UserDtailsDto();
        BeanUtils.copyProperties(savedUser, userDtailsDto);

        return userDtailsDto;
    }
}
