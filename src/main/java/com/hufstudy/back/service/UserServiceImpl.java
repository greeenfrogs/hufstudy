package com.hufstudy.back.service;

import com.hufstudy.back.domain.User;
import com.hufstudy.back.dto.UserConverter;
import com.hufstudy.back.dto.UserDTO;
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

    @Override
    @Transactional
    public UserDTO updateNickname(Long userId, String newNickname) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with Id: " + userId));
        user.setNickname(newNickname);
        userRepository.save(user);
        return UserConverter.toUserDTO(user);
    }

    @Override
    @Transactional
    public UserDTO updateEmail(Long userId, String newEmail) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with Id: " + userId));
        user.setEmail(newEmail);
        userRepository.save(user);
        return UserConverter.toUserDTO(user);
    }

    @Override
    @Transactional
    public UserDTO updatePassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with Id: " + userId));
        user.setPassword(newPassword);
        userRepository.save(user);
        return UserConverter.toUserDTO(user);
    }

    // 이미 사용 중인 이메일 있을 때 예외
    @Override
    @Transactional
    public UserDTO registerUser(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use");
        }
        User user = UserConverter.toUserEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserConverter.toUserDTO(savedUser);
    }

    // 이메일, 비번 일치하지 않으면 예외
    @Override
    @Transactional
    public UserDTO loginUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        return UserConverter.toUserDTO(user);
    }

    //닉네임으로 이메일 찾음 없으면 예외
    @Override
    @Transactional
    public String findUserEmailByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname)
                .orElseThrow(() -> new RuntimeException("No user found with nickname: " + nickname));
        return user.getEmail();
    }

    // 이메일로 비번 찾기 보안때메 실제 비번 반환 안 하는게 좋은데 일단 나중에 생각할게
    @Override
    @Transactional
    public String findUserPasswordByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("No user found with email: " + email));
        return user.getPassword();
    }

    @Override
    @Transactional
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with Id: " + id));
        return UserConverter.toUserDTO(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}