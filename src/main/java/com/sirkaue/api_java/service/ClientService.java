package com.sirkaue.api_java.service;

import com.sirkaue.api_java.dto.ClientDto;
import com.sirkaue.api_java.entity.Client;
import com.sirkaue.api_java.repository.ClientRepository;
import com.sirkaue.api_java.service.exception.ControllerNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    @Transactional(readOnly = true)
    public ClientDto findById(Long id) {
        Optional<Client> obj = clientRepository.findById(id);

        Client client = obj.orElseThrow(() -> new ControllerNotFoundException("Entity not found"));
        return new ClientDto(client);
    }

    @Transactional
    public ClientDto insert(ClientDto dto) {
        Client entity = new Client();
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity = clientRepository.save(entity);
        return new ClientDto(entity);
    }

    @Transactional
    public ClientDto update(Long id, ClientDto dto) {
        try {
            Client entity = clientRepository.getReferenceById(id);
            entity.setName(dto.getName());
            entity.setCpf(dto.getCpf());
            entity.setIncome(dto.getIncome());
            entity.setBirthDate(dto.getBirthDate());
            entity.setChildren(dto.getChildren());
            entity = clientRepository.save(entity);
            return new ClientDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException(String.format("ID %s not found", id));
        }
    }
}
