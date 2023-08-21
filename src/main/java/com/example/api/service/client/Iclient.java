package com.example.api.service.client;

import com.example.api.dto.ClientDTO;
import com.example.api.dto.PersonDTO;
import com.example.api.infraestructure.CustomExceptionHandler;
import com.example.api.model.Client;
import com.example.api.model.Person;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface Iclient {
    public CompletableFuture<ClientDTO> CreateCLient(ClientDTO clientData);
    public CompletableFuture<ClientDTO> UpdateClient(ClientDTO person) throws CustomExceptionHandler;
    public Optional<Client> GetClient(String id)  throws CustomExceptionHandler;
    public String deleteClient(String id);
}
