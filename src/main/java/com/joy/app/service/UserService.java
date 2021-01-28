package com.joy.app.service;

import com.joy.app.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDetails);
}
