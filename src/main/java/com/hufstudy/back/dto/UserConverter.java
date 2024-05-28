package com.hufstudy.back.dto;

import com.hufstudy.back.domain.User;

public class UserConverter {

    // UserDTO를 User 엔티티로 변환, 회원가입 회원정보 수정할때 써
    public static User toUserEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setNickname(userDTO.getNickname());
        return user;
    }

    // User 엔티티를 UserDTO로 변환
    public static UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setNickname(user.getNickname());
        return userDTO;
    }

}