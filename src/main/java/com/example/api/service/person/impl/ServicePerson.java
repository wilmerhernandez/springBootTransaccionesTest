package com.example.api.service.person.impl;

import com.example.api.dto.PersonDTO;
import com.example.api.infraestructure.CustomExceptionHandler;
import com.example.api.model.Person;
import com.example.api.repository.PersonRepository;
import com.example.api.service.person.Iperson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class ServicePerson implements Iperson {

    @Autowired
    PersonRepository personRepo;
    @Override
    public CompletableFuture<PersonDTO> CreatePerson(PersonDTO person) {
        Person request = new Person();
        request.setAddress(person.getAddress());
        request.setName(person.getName());
        request.setGenre(person.getGenre());
        request.setPhone(person.getPhone());
        request.setAge(person.getAge());

        personRepo.save(request);
        return CompletableFuture.completedFuture(person);
    }

    @Override
    public PersonDTO UpdatePerson(PersonDTO person) throws CustomExceptionHandler {
        Person request = personRepo.findById(person.getId()).orElseThrow(()-> new CustomExceptionHandler());
            if(person.getAddress()!=null){request.setAddress(person.getAddress());}
            if(person.getName()!=null){request.setName(person.getName());}
            if(person.getGenre()!=null){request.setGenre(person.getGenre());}
            if(person.getPhone()!=null){request.setPhone(person.getPhone());}
            if(person.getAge()!=null){ request.setAge(person.getAge());}
            personRepo.save(request);
            return person;

    }

    @Override
    public Optional<Person> GetPerson(String id) throws CustomExceptionHandler {
        return Optional.ofNullable(personRepo.findById(Integer.parseInt(id)).orElseThrow(() -> new CustomExceptionHandler()));

    }

    @Override
    public String deletePerson(String id) {
        personRepo.deleteById(Integer.parseInt(id));
        return "Dato Eliminado";
    }
}
