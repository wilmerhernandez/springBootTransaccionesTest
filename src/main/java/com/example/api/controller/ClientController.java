package com.example.api.controller;

import com.example.api.dto.ClientDTO;
import com.example.api.infraestructure.CustomExceptionHandler;
import com.example.api.model.Client;
import com.example.api.model.Person;
import com.example.api.service.client.impl.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ServiceClient service;
    @PostMapping("")
    public CompletableFuture<ClientDTO> postCustomer(@RequestBody ClientDTO clientData) {
        try {
            return service.CreateCLient(clientData);
        }catch (Exception e){
            try {
                throw new Exception(e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    @PutMapping("")
    public CompletableFuture<ClientDTO> updatePerson(@RequestBody ClientDTO person) throws CustomExceptionHandler {
        return service.UpdateClient(person);
    }

    @GetMapping("/{id}")
    public Optional<Client> getPerson(@PathVariable String id) throws CustomExceptionHandler {
        return service.GetClient(id);
    }
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable String id)  {
        return service.deleteClient(id);
    }

}
