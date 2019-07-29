package com.nv.account.services;

import com.nv.account.dtos.AccountDto;
import com.nv.account.dtos.CreateAccountDto;
import com.nv.account.dtos.CreateTransactionDto;
import com.nv.account.dtos.TransactionDto;
import com.nv.account.models.Account;
import com.nv.account.models.Transaction;
import com.nv.account.repositories.AccountRepository;
import com.nv.account.repositories.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AccountService(AccountRepository accountRepository,
                          TransactionRepository transactionRepository,
                          ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    public AccountDto createAccount(CreateAccountDto createAccountDto) {
        Account account = modelMapper.map(createAccountDto, Account.class);
        account.setEnabled(Boolean.TRUE);
        return modelMapper.map(accountRepository.save(account), AccountDto.class);
    }

    public AccountDto getAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new EntityNotFoundException("Account does not exist"));
        return modelMapper.map(account, AccountDto.class);
    }

    public TransactionDto addTransaction(Long accountId, CreateTransactionDto createTransactionDto) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new EntityNotFoundException("Account does not exist"));
        Transaction transaction = modelMapper.map(createTransactionDto, Transaction.class);
        transaction.setAccount(account);
        return modelMapper.map(transactionRepository.save(transaction), TransactionDto.class);
    }

    public List<TransactionDto> getAllTransaction(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new EntityNotFoundException("Account does not exist"));
        return account.getTransactions().stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                .collect(Collectors.toList());
    }
}
