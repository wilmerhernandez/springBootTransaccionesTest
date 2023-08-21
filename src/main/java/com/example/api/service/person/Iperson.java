package com.example.api.service.person;

import com.example.api.dto.PersonDTO;
import com.example.api.infraestructure.CustomExceptionHandler;
import com.example.api.model.Person;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface Iperson {
        public CompletableFuture<PersonDTO> CreatePerson(PersonDTO person);
    public PersonDTO UpdatePerson(PersonDTO person) throws CustomExceptionHandler;
    public Optional<Person> GetPerson(String id) throws CustomExceptionHandler;
    public String deletePerson(String id);
    }
