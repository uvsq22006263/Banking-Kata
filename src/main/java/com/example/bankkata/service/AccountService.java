package com.example.bankkata.service;

import com.example.bankkata.model.Operation;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    void deposit(Long accountId, BigDecimal amount);

    void withdraw(Long accountId, BigDecimal amount);

    List<Operation> getStatement(Long accountId);
}