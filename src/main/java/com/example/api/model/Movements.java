package com.example.api.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "movements")
@Getter
@Setter
public class Movements {
    @Id
    private int id;

    @Column(name = "date")
    private String date;
    @Column(name = "type")
    private String type;
    @Column(name = "value")
    private String value;
    @Column(name = "balance")
    private String balance;
}
