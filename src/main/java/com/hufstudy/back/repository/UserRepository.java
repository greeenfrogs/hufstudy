package com.hufstudy.back.repository;

import com.hufstudy.back.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// 로그인에서 회원 이메일 이용한 사용자 검증 수행 가능
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByNickname(String nickname);

}
