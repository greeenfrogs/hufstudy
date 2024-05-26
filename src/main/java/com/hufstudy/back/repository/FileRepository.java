package com.hufstudy.back.repository;

import com.hufstudy.back.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    List<File> findByUserIdAndFileType(Long userId, String fileType);
}
