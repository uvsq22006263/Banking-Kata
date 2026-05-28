package com.example.bankkata.repository;

import com.example.bankkata.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository
        extends JpaRepository<Account, Long> {
}