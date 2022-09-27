package com.socialmedia.webApp.services;

import com.socialmedia.webApp.payload.UserDto;

import java.util.List;

public interface UserServices {
    //create user
    UserDto createUser(UserDto userDto);

    //update
    UserDto updateUser(UserDto userDto, Long userId);

    //delete
    void deleteUser(Long userId);

    //get user by id
    UserDto getUserById(Long userId);

    //get all user
    List<UserDto> getAllUser();
}
