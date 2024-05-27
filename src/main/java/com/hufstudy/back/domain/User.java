package com.hufstudy.back.domain;

import jakarta.persistence.*;

import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files;


}