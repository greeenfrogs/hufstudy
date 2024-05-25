package com.hufstudy.back.service;

import com.hufstudy.back.domain.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
public interface FileService {
    File saveFile(MultipartFile file) throws IOException;
}
