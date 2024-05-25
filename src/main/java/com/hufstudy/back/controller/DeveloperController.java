package com.hufstudy.back.controller;

import com.hufstudy.back.domain.Developer;
import com.hufstudy.back.domain.File;
import com.hufstudy.back.service.DeveloperService;
import com.hufstudy.back.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/developer")
public class DeveloperController {

    private final DeveloperService developerService;
    private final FileService fileService;

    @Autowired
    public DeveloperController(DeveloperService developerService, FileService fileService) {
        this.developerService = developerService;
        this.fileService = fileService;
    }

    @PutMapping("/{developerId}/shortBio")
    public Developer updateShortBio(@PathVariable Long developerId, @RequestParam String shortBio) {
        return developerService.updateShortBio(developerId, shortBio);
    }

    @PutMapping("/{developerId}/Introduction")
    public Developer updateIntroduction(@PathVariable Long developerId, @RequestParam String introduction) {
        return developerService.updateIntroduction(developerId, introduction);
    }

    // 파일 업로드 요청 처리
    @PostMapping("/{developerId}/files")
    public ResponseEntity<Developer> addDeveloperFile(@PathVariable Long developerId, @RequestParam("file") MultipartFile file) {
        try {
            // 파일을 저장하고 파일 엔티티를 가져옴
            File savedFile = fileService.saveFile(file);

            // 파일 엔티티를 클라이언트와 연관시킴
            Developer updatedDeveloper = developerService.addFileToDeveloper(developerId, savedFile);

            return new ResponseEntity<>(updatedDeveloper, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
