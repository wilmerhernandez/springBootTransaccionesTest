package com.example.api.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {
    @Id
    @Column(name = "number")
    private String number;
    @Column(name = "typeAcccount")
    private String typeAcccount;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    @JsonIgnoreProperties("account")
    private Client client;
    @Column(name = "value")
    private String value;
}
