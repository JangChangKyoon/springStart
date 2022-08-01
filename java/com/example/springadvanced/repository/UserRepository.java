package com.example.springadvanced.repository;

import com.example.springadvanced.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);//user 테이블에서 username을 찾겠다.
}