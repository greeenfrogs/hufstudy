package com.hufstudy.back.service;

import com.hufstudy.back.domain.Client;

public interface ClientService {
    Client updateClientName(Long clientId, String client);
    Client updateClientInfo(Long clientId, String clientInfo);
}
