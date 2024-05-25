package com.hufstudy.back.service;

import com.hufstudy.back.domain.Client;
import com.hufstudy.back.domain.File;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ClientService {
    Client updateClientName(Long clientId, String client);
    Client updateClientInfo(Long clientId, String clientInfo);
    Client addFileToClient(Long clientId, File file);

}
