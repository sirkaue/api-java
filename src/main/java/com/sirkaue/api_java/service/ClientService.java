package com.sirkaue.api_java.service;

import com.sirkaue.api_java.entity.Client;
import com.sirkaue.api_java.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
