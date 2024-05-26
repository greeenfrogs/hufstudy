package com.hufstudy.back.controller;

import com.hufstudy.back.domain.File;
import com.hufstudy.back.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/{userId}/developer")
    public Map<String, Object> uploadDeveloperFile(@PathVariable("userId") Long userId, @RequestParam("file") MultipartFile file) {
        return uploadFile(file, userId, "DEVELOPER");
    }

    @PostMapping("/{userId}/client")
    public Map<String, Object> uploadClientFile(@PathVariable("userId") Long userId, @RequestParam("file") MultipartFile file) {
        return uploadFile(file, userId, "CLIENT");
    }

    @GetMapping("/{userId}/developer")
    public List<File> getDeveloperFiles(@PathVariable("userId") Long userId) {
        return fileService.getFilesByUserIdAndFileType(userId, "DEVELOPER");
    }

    @GetMapping("/{userId}/client")
    public List<File> getClientFiles(@PathVariable("userId") Long userId) {
        return fileService.getFilesByUserIdAndFileType(userId, "CLIENT");
    }

    private Map<String, Object> uploadFile(MultipartFile file, Long userId, String fileType) {
        Map<String, Object> response = new HashMap<>();
        try {
            File uploadFile = fileService.saveFile(file, userId, fileType);
            response.put("message", "File uploaded jonna successfully");
            response.put("file", uploadFile);
        } catch (IOException e) {
            response.put("message", "Failed to upload file: " + e.getMessage());
        }
        return response;
    }
}