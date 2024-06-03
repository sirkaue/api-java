package com.sirkaue.api_java.controller;

import com.sirkaue.api_java.entity.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {


    @GetMapping
    public ResponseEntity<List<Client>> findAll() {

        // criando mock
        List<Client> list = new ArrayList<>();

        list.add(new Client(1L, "Kauê", "12345678900", 3000.00, 0));
        list.add(new Client(2L, "João", "12345678900", 2430.00, 1));
        list.add(new Client(3L, "Julia", "12345978900", 2330.00, 2));
        list.add(new Client(4L, "Julio", "12345328900", 30000.00, 6));
        list.add(new Client(5L, "Renato", "12345878900", 3500.00, 3));
        list.add(new Client(6L, "Kleber", "12340078900", 5000.00, 1));
        list.add(new Client(7L, "Larissa", "12364678900", 2000.00, 0));
        list.add(new Client(8L, "Monteiro", "12115678900", 7000.00, 3));
        list.add(new Client(9L, "Valverde", "12235678900", 5500.00, 4));
        list.add(new Client(10L, "Júnior", "12361678900", 3700.00, 2));

        return ResponseEntity.ok().body(list);
    }
}
