package com.example.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessageDTO {
    private String code;
    private String message;

    public ErrorMessageDTO(String s, String s1) {
        this.code = s;
        this.message= s1;
    }
}
