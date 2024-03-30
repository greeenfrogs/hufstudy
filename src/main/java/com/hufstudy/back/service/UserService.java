package com.hufstudy.back.service;

import com.hufstudy.back.repository.UserRepository;
import com.hufstudy.back.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //닉네임 변경
    @Transactional
    public User updateNickname(Long userId, String newNickname) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with Id: " + userId));
        user.setNickname(newNickname);
        return userRepository.save(user);
    }

    @Transactional
    public User updateEmail(Long userId, String newEmail) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with Id: " + userId));
        user.setEmail(newEmail);
        return userRepository.save(user);
    }

    @Transactional
    public User updatePassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with Id: " + userId));
        user.setPassword(newPassword);
        return userRepository.save(user);
    }

}
