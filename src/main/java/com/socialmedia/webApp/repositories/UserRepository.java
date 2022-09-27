package com.socialmedia.webApp.repositories;

import com.socialmedia.webApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
