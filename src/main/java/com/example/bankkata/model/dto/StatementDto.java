package com.example.bankkata.model.dto;

import java.util.List;

public record StatementDto(

        List<OperationDto> operations

) {
}