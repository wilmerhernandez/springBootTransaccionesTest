package com.example.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovementReqDTO {
    private boolean debit;
    private String value;
    private String accountNumber;

}
