package com.example.selectshopfromjpa.service;

import com.example.selectshopfromjpa.model.Users;
import com.example.selectshopfromjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUser() {
// 테스트 회원 "user1" 객체 추가
        Users beforeSavedUser = new Users("user1", "정국", "불족발");
// 회원 "user1" 객체를 영속화, 디버그하여 객체 주소 조회
        Users savedUser = userRepository.save(beforeSavedUser);

// beforeSavedUser: 영속화되기 전 상태의 자바 일반객체
// savedUser:영속성 컨텍스트 1차 캐시에 저장된 객체
        assert(beforeSavedUser != savedUser);

// 회원 "user1" 을 조회
        Users foundUser1 = userRepository.findById("user1").orElse(null);
        assert(foundUser1 == savedUser);

// 회원 "user1" 을 또 조회
        Users foundUser2 = userRepository.findById("user1").orElse(null);
        assert(foundUser2 == savedUser);

// 회원 "user1" 을 또또 조회
        Users foundUser3 = userRepository.findById("user1").orElse(null);
        assert(foundUser3 == savedUser);

        return foundUser3;
    }

    public Users deleteUser() {
// 테스트 회원 "user1" 객체 추가
        Users firstUser = new Users("user1", "지민", "엄마는 외계인");
// 회원 "user1" 객체를 영속화
        Users savedFirstUser = userRepository.save(firstUser);

// 회원 "user1" 삭제
        userRepository.delete(savedFirstUser);

// 회원 "user1" 조회
        Users deletedUser1 = userRepository.findById("user1").orElse(null);
//1차 캐시에서 진짝 없는지 확인하기
        assert(deletedUser1 == null);

// -------------------
// 테스트 회원 "user1" 객체를 다시 추가
// 회원 "user1" 객체 추가
        Users secondUser = new Users("user1", "지민", "엄마는 외계인");

// 회원 "user1" 객체를 영속화
        Users savedSecondUser = userRepository.save(secondUser);
// 첫번째 user와 다름
// 실질적으로 내용은 같지만 객체가 다르므로 다시 DB에 저장됨
        assert(savedFirstUser != savedSecondUser);
        assert(savedFirstUser.getUsername().equals(savedSecondUser.getUsername()));
        assert(savedFirstUser.getNickname().equals(savedSecondUser.getNickname()));
        assert(savedFirstUser.getFavoriteFood().equals(savedSecondUser.getFavoriteFood()));

// 회원 "user1" 조회
// 1차 캐시에 있는 내용과 디비 내용 일치여부 확인
        Users foundUser = userRepository.findById("user1").orElse(null);
        assert(foundUser == savedSecondUser);

        return foundUser;
    }
//캐시에만 저장되고 DB에는 반영되지 않는 케이스
    public Users updateUserFail() {
// 회원 "user1" 객체 추가
        Users user = new Users("user1", "뷔", "콜라");
// 회원 "user1" 객체를 영속화 //DB와 1캐시에 저장됨
        Users savedUser = userRepository.save(user);

// 회원의 nickname 변경 //DB를 바꾸는 것이 아닌 갯채만 바꾸는 것임
        savedUser.setNickname("얼굴천재");
// 회원의 favoriteFood 변경
        savedUser.setFavoriteFood("버거킹");

// 회원 "user1" 을 조회
        Users foundUser = userRepository.findById("user1").orElse(null);
// 중요!) foundUser 는 DB 값이 아닌 1차 캐시에서 가져오는 값
        assert(foundUser == savedUser);
        assert(foundUser.getUsername().equals(savedUser.getUsername()));
        assert(foundUser.getNickname().equals(savedUser.getNickname()));
        assert(foundUser.getFavoriteFood().equals(savedUser.getFavoriteFood()));

        return foundUser;
    }

    public Users updateUser1() {
// 테스트 회원 "user1" 생성
        Users user = new Users("user1", "RM", "고기");
// 회원 "user1" 객체를 영속화
        Users savedUser1 = userRepository.save(user);

// 회원의 nickname 변경
        savedUser1.setNickname("남준이");
// 회원의 favoriteFood 변경
        savedUser1.setFavoriteFood("육회");

// user1 을 저장
        Users savedUser2 = userRepository.save(savedUser1);
        assert(savedUser1 == savedUser2);

        return savedUser2;
    }

    @Transactional
    public Users updateUser2() {
// 테스트 회원 "user1" 생성
// 회원 "user1" 객체 추가
        Users user = new Users("user1", "진", "꽃등심");
// 회원 "user1" 객체를 영속화
        Users savedUser = userRepository.save(user);

// 회원의 nickname 변경
        savedUser.setNickname("월드와이드핸섬 진");
// 회원의 favoriteFood 변경
        savedUser.setFavoriteFood("까르보나라");

        return savedUser;
    }
}