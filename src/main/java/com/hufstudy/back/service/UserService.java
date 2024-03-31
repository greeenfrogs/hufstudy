package com.hufstudy.back.service;

import com.hufstudy.back.domain.User;

public interface UserService {
    User updateNickname(Long userId, String newNickname);

    User updateEmail(Long userId, String newEmail);

    User updatePassword(Long userId, String newPassWord);
}