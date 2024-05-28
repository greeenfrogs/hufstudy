package com.hufstudy.back.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String filePath;
    private String fileType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public File(String fileName, String filePath, String fileType, User user) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.user = user;
    }
}
