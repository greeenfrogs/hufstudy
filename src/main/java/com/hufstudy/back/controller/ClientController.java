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

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
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
}
