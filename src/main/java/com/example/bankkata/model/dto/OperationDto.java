package com.example.bankkata.model.dto;

import com.example.bankkata.model.enums.OperationType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OperationDto(

        OperationType type,
        BigDecimal amount,
        BigDecimal balance,
        LocalDateTime date

) {
}