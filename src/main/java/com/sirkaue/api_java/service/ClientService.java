package com.sirkaue.api_java.service;

import com.sirkaue.api_java.dto.ClientDto;
import com.sirkaue.api_java.entity.Client;
import com.sirkaue.api_java.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<ClientDto> findAll() {
        List<Client> list = clientRepository.findAll();

        List<ClientDto> listDto = list.stream()
                .map(x -> new ClientDto(x)).collect(Collectors.toList());
        return listDto;
    }
}
