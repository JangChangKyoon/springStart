package com.example.blogclone.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private boolean admin = false;
    private String adminToken = "";

//    public SignupRequestDto(String username, String password, UserRoleEnum role) {//, Timestamped createAt, Timestamped modifiredAt) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//    }
}
