package com.hufstudy.back.service;

import com.hufstudy.back.domain.User;
import com.hufstudy.back.dto.UserDTO;

public interface UserService {
    // 회원정보 수정 기능
    UserDTO updateNickname(Long userId, String newNickname);
    UserDTO updateEmail(Long userId, String newEmail);
    UserDTO updatePassword(Long userId, String newPassword);

    //회원가입 기능
    UserDTO registerUser(UserDTO userDTO);

    //로그인 기능
    UserDTO loginUser(String email, String password);

    // 아이디, 비밀번호 찾기 기능
    String findUserEmailByNickname(String nickname);
    String findUserPasswordByEmail(String email);

    // id로 회원 조회 기능
    UserDTO findUserById(Long id);

    //회원 삭제 기능
    void deleteUserById(Long id);
}