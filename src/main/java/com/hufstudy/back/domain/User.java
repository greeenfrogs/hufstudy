package com.hufstudy.back.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users") //충돌하지 않는 이름 사용
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 생성 디비가 알아서
    private Long id;

    private String nickname;
    private String email;
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Developer developer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Client client;


    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
