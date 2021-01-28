package com.joy.app.ui.controller;

import com.joy.app.service.impl.UserServiceImpl;
import com.joy.app.shared.dto.UserDto;
import com.joy.app.ui.model.request.UserRequestModel;
import com.joy.app.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/users")
    public String getUser(){
        return "get user";
    }
    @RequestMapping(method= RequestMethod.POST, value = "/users")
    public UserRest createUser(@RequestBody UserRequestModel userDetails){
        UserRest returnValue=new UserRest();
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);
//        System.out.println(userDto.getEmail());
//        returnValue.setUserId("123");

//        UserDto obj=new UserDto();
//        obj.setUserId("999");
//        obj.setEmail("jh@df.com");
//        obj.setFirstName("joy");
//        obj.set
        UserDto createdUser=userService.createUser(userDto);
//        System.out.println(createdUser.getEmail());

        BeanUtils.copyProperties(createdUser,returnValue);
        return returnValue;
    }
}
