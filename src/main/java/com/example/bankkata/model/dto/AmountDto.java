package com.example.bankkata.model.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AmountDto(

        @NotNull
        BigDecimal amount

) {
}