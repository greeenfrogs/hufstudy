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

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PutMapping("/{developerId}/shortBio")
    public Developer updateShortBio(@PathVariable Long developerId, @RequestParam String shortBio) {
        return developerService.updateShortBio(developerId, shortBio);
    }

    @PutMapping("/{developerId}/Introduction")
    public Developer updateIntroduction(@PathVariable Long developerId, @RequestParam String introduction) {
        return developerService.updateIntroduction(developerId, introduction);
    }
}
