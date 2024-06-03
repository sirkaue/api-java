package com.sirkaue.api_java.controller;

import com.sirkaue.api_java.entity.Client;
import com.sirkaue.api_java.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> list = clientService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
