package com.hufstudy.back.service;

import com.hufstudy.back.domain.User;
import com.hufstudy.back.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //닉네임 변경
    @Override
    @Transactional
    public User updateNickname(Long userId, String newNickname) {
        return userRepository.findById(userId).map(existingUser -> {
            existingUser.setNickname(newNickname);
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found with Id: " + userId));
    }

    @Override
    @Transactional
    public User updateEmail(Long userId, String newEmail) {
        return userRepository.findById(userId).map(existingUser -> {
            existingUser.setEmail(newEmail);
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found with Id: " + userId));
    }

    @Override
    @Transactional
    public User updatePassword(Long userId, String newPassword) {
        return userRepository.findById(userId).map(existingUser -> {
            existingUser.setPassword(newPassword);
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found with Id: " + userId));
    }

}
