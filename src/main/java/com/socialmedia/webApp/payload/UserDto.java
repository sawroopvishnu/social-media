package com.socialmedia.webApp.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String userName;
    private String userEmail;
}
