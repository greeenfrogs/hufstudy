package com.hufstudy.back.service;

import com.hufstudy.back.domain.Client;
import com.hufstudy.back.domain.File;
import com.hufstudy.back.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public Client updateClientName(Long clientId, String clientName) {
        return clientRepository.findById(clientId).map(existingClient -> {
            existingClient.setClient(clientName);
            return clientRepository.save(existingClient);
        }).orElseThrow(() -> new RuntimeException("Client not found with id " + clientId));
    }

    @Override
    @Transactional
    public Client updateClientInfo(Long clientId, String clientInfo) {
        return clientRepository.findById(clientId).map(existingClient -> {
            existingClient.setClientInfo(clientInfo);
            return clientRepository.save(existingClient);
        }).orElseThrow(() -> new RuntimeException("Client not found with id " + clientId));

    }

}
