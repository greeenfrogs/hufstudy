package com.hufstudy.back.controller;

import com.hufstudy.back.domain.Client;
import com.hufstudy.back.domain.File;
import com.hufstudy.back.service.ClientService;
import com.hufstudy.back.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;
    private final FileService fileService;

    @Autowired
    public ClientController(ClientService clientService, FileService fileService) {
        this.clientService = clientService;
        this.fileService = fileService;
    }

    // 의뢰처 변경 요청 처리
    @PutMapping("/{clientId}/clientName")
    public Client updateClient(@PathVariable Long clientId, @RequestParam String clientName) {
        return  clientService.updateClientName(clientId, clientName);
    }

    @PutMapping("/{clientId}/clientInfo")
    public Client updateCInfo(@PathVariable Long clientId, @RequestParam String clientInfo) {
        return clientService.updateClientInfo(clientId, clientInfo);
    }
    // 파일 업로드 요청 처리
    @PostMapping("/{clientId}/files")
    public ResponseEntity<Client> addClientFile(@PathVariable Long clientId, @RequestParam("file") MultipartFile file) {
        try {
            // 파일을 저장하고 파일 엔티티를 가져옴
            File savedFile = fileService.saveFile(file);

            // 파일 엔티티를 클라이언트와 연관시킴
            Client updatedClient = clientService.addFileToClient(clientId, savedFile);

            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
