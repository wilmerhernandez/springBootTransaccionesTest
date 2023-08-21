package com.example.api.dto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class ClientDTO {
    private int id;
    private PersonDTO person;
    private String password;
    private boolean status;
}
