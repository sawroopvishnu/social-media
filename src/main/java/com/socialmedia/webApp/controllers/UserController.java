package com.socialmedia.webApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.webApp.payload.ApiResponse;
import com.socialmedia.webApp.payload.UserDto;
import com.socialmedia.webApp.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserServices userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createUserDto, HttpStatus.CREATED);
		
	}
	
	
	// update user
		@PutMapping("/{userId}")
		public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable ("userId") Long userId){
			UserDto updatedUser = this.userService.updateUser(userDto, userId);
			return ResponseEntity.ok(updatedUser);
			
		}

		
		     // delete user by id
			@DeleteMapping("/{userId}")
			public ResponseEntity<ApiResponse> deleteUser(@PathVariable ("userId") Long userId){
				this.userService.deleteUser(userId);
				return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true), HttpStatus.OK);
			}
		
		// get All Users
		@GetMapping("/")
		public ResponseEntity<List<UserDto>> getAllUsers(){
			return ResponseEntity.ok(this.userService.getAllUser());
		}
		
		
		// get User ById  
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
			return ResponseEntity.ok(this.userService.getUserById(userId));
		}


}
