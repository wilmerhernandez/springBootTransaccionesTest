package com.example.api.dto;

import com.example.api.model.Client;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class AccountDTO {
    @Id
    private int id;
    private String number;
    private String typeAcccount;
    private boolean status;
    private Client client;
    private String value;
}
