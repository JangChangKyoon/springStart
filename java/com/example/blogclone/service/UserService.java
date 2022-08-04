package com.example.blogclone.service;

import com.example.blogclone.dto.SignupRequestDto;
import com.example.blogclone.model.UserRoleEnum;
import com.example.blogclone.model.Users;
import com.example.blogclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";
//    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequestDto requestDto) {
        // 회원 ID 중복 확인
        String username = requestDto.getUsername();
        Optional<Users> foundId = userRepository.findByUsername(username);
        if (foundId.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        String password = passwordEncoder.encode(requestDto.getPassword());
        //String password = requestDto.getPassword();
        String email = requestDto.getEmail();
        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USERS;
        if (requestDto.isAdmin()) {
            //* isAdmin은 어디서 튀어나온 것인가?
            //* signupRequestDto에서 맴버변수를 생성해주니 이 매소드 사용가능해짐
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        Users user = new Users(username, password, email, role);
        userRepository.save(user);
    }





        // 패스워드 암호화
//        String password = passwordEncoder.encode(requestDto.getPassword());
//        String email = requestDto.getEmail();

        // 사용자 ROLE 확인
//        UserRoleEnum role = UserRoleEnum.USERS;
//        if (requestDto.isAdmin()) {
//            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
//                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
//            }
//            role = UserRoleEnum.ADMIN;
//        }
//        Users user = new Users(username, password, email, role);
//        userRepository.save(user);
}