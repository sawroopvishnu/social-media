package com.socialmedia.webApp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User /* implements UserDetails */{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;
    
    @Column(name = "user_email")
   // @NotEmpty(message = "Email cannot be empty")
    private String userEmail;
    
    @Column(name = "password")
    private String password;

	/*
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	 * return null; }
	 * 
	 * @Override public String getPassword() { return null; }
	 * 
	 * @Override public String getUsername() { return null; }
	 * 
	 * @Override public boolean isAccountNonExpired() { return false; }
	 * 
	 * @Override public boolean isAccountNonLocked() { return false; }
	 * 
	 * @Override public boolean isCredentialsNonExpired() { return false; }
	 * 
	 * @Override public boolean isEnabled() { return false; }
	 */
}