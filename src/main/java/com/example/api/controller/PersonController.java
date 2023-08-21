package com.example.api.controller;

import com.example.api.dto.PersonDTO;
import com.example.api.infraestructure.CustomExceptionHandler;
import com.example.api.model.Person;
import com.example.api.service.person.impl.ServicePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    ServicePerson service;

    @PostMapping("")
    public CompletableFuture<PersonDTO> postPerson(@RequestBody PersonDTO person){
        return service.CreatePerson(person);
    }
    @PutMapping("")
    public PersonDTO updatePerson(@RequestBody PersonDTO person) throws CustomExceptionHandler {
        return service.UpdatePerson(person);
    }

    @GetMapping("/{id}")
    public Optional<Person> getPerson(@PathVariable String id) throws CustomExceptionHandler {
        return service.GetPerson(id);
    }
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable String id)  {
        return service.deletePerson(id);
    }
}
