package com.example.bankkata.controller;

import com.example.bankkata.model.Operation;
import com.example.bankkata.model.dto.AmountDto;
import com.example.bankkata.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Void> deposit(
            @PathVariable Long id,
            @Valid @RequestBody AmountDto dto) {

        service.deposit(id, dto.amount());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Void> withdraw(
            @PathVariable Long id,
            @Valid @RequestBody AmountDto dto) {

        service.withdraw(id, dto.amount());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/statement")
    public ResponseEntity<List<Operation>> statement(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getStatement(id)
        );
    }
}