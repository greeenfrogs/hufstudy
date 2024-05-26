package com.hufstudy.back.service;

import com.hufstudy.back.domain.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    File saveFile(MultipartFile file, Long userId, String fileType) throws IOException;
    List<File> getFilesByUserIdAndFileType(Long userId, String fileType);
}
