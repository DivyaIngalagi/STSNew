package com.spring.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jwt.api.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
