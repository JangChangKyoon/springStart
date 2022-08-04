package com.example.blogclone.repository;

import com.example.blogclone.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
//Email 을 Login ID 로 갖고 있기 때문에 findByEmail 와 중복 가입 방지를 위한 existsByEmail 만 추가합니다.