package com.example.api.dto;
import com.example.api.model.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class PersonDTO {
    private String name;
    private String genre;
    private int id;
    private String address;
    private String phone;
    private String age;
}
