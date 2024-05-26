package com.hufstudy.back.service;

import com.hufstudy.back.domain.*;
import com.hufstudy.back.repository.FileRepository;
import com.hufstudy.back.repository.UserRepository;
import com.hufstudy.back.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final FileRepository fileRepository;
    private final UserRepository userRepository;

    public FileServiceImpl(FileRepository fileRepository, UserRepository userRepository) {
        this.fileRepository = fileRepository;
        this.userRepository = userRepository;
    }
    @Override
    public File saveFile(MultipartFile file, Long userId, String fileType) throws IOException {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!"));

        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.copy(file.getInputStream(), filePath);
        File uploadFile = new File(fileName, filePath.toString(), fileType, user);
        return fileRepository.save(uploadFile);
    }
    @Override
    public List<File> getFilesByUserIdAndFileType(Long userId, String fileType) {
        return fileRepository.findByUserIdAndFileType(userId, fileType);
    }
}