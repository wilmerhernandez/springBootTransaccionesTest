package com.example.api.service.account;

import com.example.api.dto.AccountDTO;
import com.example.api.dto.MovementReqDTO;
import com.example.api.dto.PersonDTO;
import com.example.api.infraestructure.CustomExceptionHandler;

import java.util.concurrent.CompletableFuture;

public interface Iaccount {
    public CompletableFuture<AccountDTO> createAccount(AccountDTO accountDTO);
    public CompletableFuture<MovementReqDTO> movingAccount(MovementReqDTO accountDTO) throws CustomExceptionHandler;
}
