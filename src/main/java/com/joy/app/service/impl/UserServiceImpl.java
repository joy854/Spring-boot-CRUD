package com.joy.app.service.impl;

import com.joy.app.UserRepository;
import com.joy.app.io.entity.UserEntity;
import com.joy.app.service.UserService;
import com.joy.app.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userEntity.setUserId("123");
        UserEntity storedUser=userRepository.save(userEntity);

        UserDto returnValue=new UserDto();
        BeanUtils.copyProperties(storedUser,returnValue);
        return returnValue;
    }
}
