package com.example.api.model;
import com.example.api.dto.PersonDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Getter
@Setter
public class Person {
    @Column(name = "name")
    private String name;
    @Column(name = "genre")
    private String genre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "age")
    private String age;

}
