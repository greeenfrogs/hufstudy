package com.hufstudy.back.controller;

import com.hufstudy.back.domain.User;
import com.hufstudy.back.dto.UpdateRequest;
import com.hufstudy.back.dto.UserDTO;
import com.hufstudy.back.service.UserService;
import com.hufstudy.back.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserDTO> updateNickname(@PathVariable Long userId, @RequestBody UpdateRequest request) {
        UserDTO userDTO = userService.updateNickname(userId, request.getValue());
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{userId}/email")
    public ResponseEntity<UserDTO> updateEmail(@PathVariable Long userId, @RequestBody UpdateRequest request) {
        UserDTO userDTO = userService.updateEmail(userId, request.getValue());
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{userId}/password")
    public ResponseEntity<UserDTO> updatePassword(@PathVariable Long userId, @RequestBody UpdateRequest request) {
        UserDTO userDTO = userService.updatePassword(userId, request.getValue());
        return ResponseEntity.ok(userDTO);
    }

    // 회원가입 요청 처리
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO newUser = userService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // 로그인 요청 처리
    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO userDTO) {
        UserDTO loggedInUser = userService.loginUser(userDTO.getEmail(), userDTO.getPassword());
        return ResponseEntity.ok(loggedInUser);
    }

    // 아이디 찾기 요청 처리
    @GetMapping("/find-email")
    public ResponseEntity<String> findUserEmailByNickname(@RequestParam String nickname) {
        String email = userService.findUserEmailByNickname(nickname);
        return ResponseEntity.ok(email);
    }


    // 비밀번호 찾기 요청 처리, 비번 그냥 덜렁 반환 안 좋대 근데 나중에 바꿀게
    @GetMapping("/find-password")
    public ResponseEntity<String> findUserPasswordByEmail(@RequestParam String email) {
        String password = userService.findUserPasswordByEmail(email);
        return ResponseEntity.ok(password);
    }

    // 회원 정보 조회 요청 처리
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long userId) {
        UserDTO userDTO = userService.findUserById(userId);
        return ResponseEntity.ok(userDTO);
    }

    // 회원 삭제 요청 처리
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }
}