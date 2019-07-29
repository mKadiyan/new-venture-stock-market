package com.nv.account.controllers;

import com.nv.account.dtos.AccountDto;
import com.nv.account.dtos.CreateAccountDto;
import com.nv.account.dtos.CreateTransactionDto;
import com.nv.account.dtos.TransactionDto;
import com.nv.account.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/api/v1/accounts", method = POST)
    public ResponseEntity<AccountDto> getAccounts(@RequestBody @Validated CreateAccountDto createAccountDto) {
        return ResponseEntity.ok(accountService.createAccount(createAccountDto));
    }

    @RequestMapping(value = "/api/v1/accounts/{accountId}", method = GET)
    public ResponseEntity<AccountDto> getAccounts(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getAccount(accountId));
    }

    @RequestMapping(value = "/api/v1/accounts/{accountId}/transactions", method = POST)
    public ResponseEntity<TransactionDto> addTransactions(@PathVariable Long accountId,
                                                          @RequestBody CreateTransactionDto createTransactionDto) {
        return ResponseEntity.ok(accountService.addTransaction(accountId,createTransactionDto));
    }

    @RequestMapping(value = "/api/v1/accounts/{accountId}/transactions", method = GET)
    public ResponseEntity<List<TransactionDto>> getAllTransactions(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getAllTransaction(accountId));
    }
}
