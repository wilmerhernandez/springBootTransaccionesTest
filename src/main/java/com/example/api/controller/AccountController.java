package com.example.api.controller;

import com.example.api.dto.AccountDTO;
import com.example.api.dto.MovementReqDTO;
import com.example.api.infraestructure.CustomExceptionHandler;
import com.example.api.service.account.impl.AccountService;
import com.example.api.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService service;
    @Autowired
    RedisService redis;

    @PostMapping("")
    public CompletableFuture<AccountDTO> postCreateAccount(@RequestBody AccountDTO accountDTO) {
    return service.createAccount(accountDTO);
    }

    @PostMapping("/movement")
    public CompletableFuture<MovementReqDTO> postCreateMovement(@RequestBody MovementReqDTO movementReqDTO) throws CustomExceptionHandler {
        if(redis.getValue(movementReqDTO.getAccountNumber()).equals("3")){
            CompletableFuture<MovementReqDTO> Response = service.movingAccount(movementReqDTO);
            if(redis.getValue(movementReqDTO.getAccountNumber()).isEmpty()){
                redis.saveValue(movementReqDTO.getAccountNumber(),1);
            }else{
                int RedisValue = Integer.parseInt(redis.getValue(movementReqDTO.getAccountNumber()))+1;
                System.out.println(RedisValue);
                redis.saveValue(movementReqDTO.getAccountNumber(),RedisValue);
            }
            return Response;
        }else{
            throw new CustomExceptionHandler("Exedes el numero de movimientos diarios");
        }

    }


}
