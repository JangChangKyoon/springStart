package com.example.selectshopfromjpa.repository;

import com.example.selectshopfromjpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, String> {
    //FavariteFood를 조건으로 검색
    void findByyFavoriteFood(String food);
    //FavoriteFood 전체 회원 조회
    List<Users> findAllByFavoriteFood(String food);
}