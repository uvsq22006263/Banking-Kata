package com.example.bankkata.service.impl;

import com.example.bankkata.model.Account;
import com.example.bankkata.model.Operation;
import com.example.bankkata.model.enums.OperationType;
import com.example.bankkata.repository.AccountRepository;
import com.example.bankkata.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public void deposit(Long accountId, BigDecimal amount) {

        Account account = repository.findById(accountId)
                .orElseThrow(() ->
                        new RuntimeException("Account not found"));

        account.setBalance(
                account.getBalance().add(amount)
        );

        Operation operation = Operation.builder()
                .type(OperationType.DEPOSIT)
                .amount(amount)
                .balance(account.getBalance())
                .date(LocalDateTime.now())
                .account(account)
                .build();

        account.getOperations().add(operation);

        repository.save(account);
    }

    @Override
    public void withdraw(Long accountId, BigDecimal amount) {

        Account account = repository.findById(accountId)
                .orElseThrow(() ->
                        new RuntimeException("Account not found"));

        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(
                account.getBalance().subtract(amount)
        );

        Operation operation = Operation.builder()
                .type(OperationType.WITHDRAWAL)
                .amount(amount)
                .balance(account.getBalance())
                .date(LocalDateTime.now())
                .account(account)
                .build();

        account.getOperations().add(operation);

        repository.save(account);
    }

    @Override
    public List<Operation> getStatement(Long accountId) {

        Account account = repository.findById(accountId)
                .orElseThrow(() ->
                        new RuntimeException("Account not found"));

        return account.getOperations();
    }
}