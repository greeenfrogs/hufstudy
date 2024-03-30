package com.hufstudy.back.controller;

import com.hufstudy.back.service.UserService;
import com.hufstudy.back.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 닉네임 변경 요청 처리
    @PutMapping("/{userId}/nickname")
    public User updateNickname(@PathVariable Long userId, @RequestParam String nickname) {
        return userService.updateNickname(userId, nickname);
    }

    @PutMapping("/{userId}/email")
    public User updateEmail(@PathVariable Long userId, @RequestParam String email) {
        return userService.updateEmail(userId, email);
    }

    @PutMapping("/{userId}/password")
    public User updatePassword(@PathVariable Long userId, @RequestParam String password) {
        return userService.updatePassword(userId, password);
    }

}
