package com.socialmedia.webApp.serviceImplementation;

import com.socialmedia.webApp.entity.User;
import com.socialmedia.webApp.exception.ResourceNotFoundException;
import com.socialmedia.webApp.payload.UserDto;
import com.socialmedia.webApp.repositories.UserRepository;
import com.socialmedia.webApp.services.UserServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User userSaved = this.userRepository.save(user);
        return this.userToDto(userSaved);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User", "userId", userId));
        user.setUserName(userDto.getUserName());
        user.setUserEmail(user.getUserEmail());
        User updatedUser = this.userRepository.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);
        return userDto1;
    }

    @Override
    public void deleteUser(Long userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
        this.userRepository.delete(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }


    //converting from Dto to user
    public User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    //converting from user to dto
    public UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
