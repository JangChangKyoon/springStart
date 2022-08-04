package com.example.blogclone.dto;
import com.example.blogclone.model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;

    public static UserDto of(Users users) {
        return new UserDto(users.getUsername());
    }
}
