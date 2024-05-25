package com.hufstudy.back.controller;

import com.hufstudy.back.domain.File;
import com.hufstudy.back.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            File savedFile = fileService.saveFile(file);
            return new ResponseEntity<>("파일이 성공적으로 업로드되었습니다: " + savedFile.getId(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("파일 업로드 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}