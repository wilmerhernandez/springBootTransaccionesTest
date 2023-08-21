package com.example.api.service.account.impl;

import com.example.api.dto.AccountDTO;
import com.example.api.dto.MovementReqDTO;
import com.example.api.infraestructure.CustomExceptionHandler;
import com.example.api.model.Account;
import com.example.api.model.Client;
import com.example.api.repository.AccountRepository;
import com.example.api.service.account.Iaccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
@Service
public class AccountService implements Iaccount {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public CompletableFuture<AccountDTO> createAccount(AccountDTO accountDTO) {
        Account accountData = new Account();
        accountData.setNumber(accountDTO.getNumber());
        accountData.setStatus(accountDTO.isStatus());
        accountData.setTypeAcccount(accountDTO.getTypeAcccount());
        accountData.setValue(accountDTO.getValue());
        Client client = new Client();
        client.setId(accountDTO.getClient().getId());
        accountData.setClient(client);
        accountRepository.save(accountData);
        return CompletableFuture.completedFuture(accountDTO);
    }

    @Override
    public CompletableFuture<MovementReqDTO> movingAccount(MovementReqDTO movementReqDTO) throws CustomExceptionHandler {
      Account account = accountRepository.findByNumber(movementReqDTO.getAccountNumber());

      System.out.println(movementReqDTO.isDebit());
      if(movementReqDTO.isDebit()){
          if(Integer.parseInt(account.getValue()) < Integer.parseInt(movementReqDTO.getValue())){
              throw new CustomExceptionHandler();
          }
          account.setValue((Integer.parseInt(account.getValue()) - Integer.parseInt(movementReqDTO.getValue())) + "");
      }else{
          account.setValue((Integer.parseInt(account.getValue()) + Integer.parseInt(movementReqDTO.getValue())) + "");
      }

        accountRepository.save(account);
        return CompletableFuture.completedFuture(movementReqDTO);
    }
}
