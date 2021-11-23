package com.example.toy.web.Dto.User;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class UserListResponseDto {
    private List<UserResponseDto> users;
    @Builder
    public UserListResponseDto(List<UserResponseDto> userInfo){
        this.users = userInfo;
    }

    public List<UserResponseDto> getUsers(){
        return this.users;
    }
}
