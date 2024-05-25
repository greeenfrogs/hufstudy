package com.hufstudy.back.service.impl;

import com.hufstudy.back.domain.File;
import com.hufstudy.back.repository.FileRepository;
import com.hufstudy.back.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public File saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = "파일 저장 경로/" + fileName;

        java.io.File destFile = new java.io.File(filePath);
        file.transferTo(destFile);

        File fileEntity = new File();
        fileEntity.setFileName(fileName);
        fileEntity.setFilePath(filePath);

        return fileRepository.save(fileEntity);
    }
}