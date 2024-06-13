package com.sirkaue.clientapi.service;

import com.sirkaue.clientapi.dto.ClientDto;
import com.sirkaue.clientapi.entity.Client;
import com.sirkaue.clientapi.repository.ClientRepository;
import com.sirkaue.clientapi.service.exception.ControllerNotFoundException;
import com.sirkaue.clientapi.service.exception.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDto> findAllPaged(Pageable pageable) {
        Page<Client> list = clientRepository.findAll(pageable);
        Page<ClientDto> listDto = list.map(x -> new ClientDto(x));
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

    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new DatabaseException("Integrity violation");
        }
        clientRepository.deleteById(id);
    }
}
