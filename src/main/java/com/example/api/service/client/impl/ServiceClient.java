package com.example.api.service.client.impl;

import com.example.api.dto.ClientDTO;
import com.example.api.infraestructure.CustomExceptionHandler;
import com.example.api.model.Client;
import com.example.api.model.Person;
import com.example.api.repository.ClientRepository;
import com.example.api.service.client.Iclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class ServiceClient implements Iclient {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public CompletableFuture<ClientDTO> CreateCLient(ClientDTO clientData) {
        try {
            Client responseClient = new Client();
            Person personData = new Person();
            personData.setId(clientData.getPerson().getId());
            responseClient.setPassword(clientData.getPassword());
            responseClient.setStatus(clientData.isStatus());
            responseClient.setPerson(personData);
            clientRepository.save(responseClient);
            return CompletableFuture.completedFuture(clientData);

        }catch (Exception e){
            try {
                throw new Exception((e));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
       }

    @Override
    public CompletableFuture<ClientDTO> UpdateClient(ClientDTO clientData) throws CustomExceptionHandler {
        Client responseClient = new Client();
        Person personData = new Person();
        personData.setId(clientData.getPerson().getId());
        responseClient.setPassword(clientData.getPassword());
        responseClient.setStatus(clientData.isStatus());
        responseClient.setPerson(personData);
        clientRepository.save(responseClient);
        return CompletableFuture.completedFuture(clientData);
    }

    public Optional<Client> GetClient(String id) throws CustomExceptionHandler {
        return Optional.ofNullable(clientRepository.findById(Integer.parseInt(id)).orElseThrow(() -> new CustomExceptionHandler()));
    }

    @Override
    public String deleteClient(String id) {
        clientRepository.deleteById(Integer.parseInt(id));
        return "dato eliminado";
    }
}
