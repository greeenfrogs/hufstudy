package com.hufstudy.back.repository;

import com.hufstudy.back.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}