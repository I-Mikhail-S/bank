package org.bank.demo.mapper;

import org.bank.demo.api.request.CreateTransactionRequest;
import org.bank.demo.api.response.CreateTransactionResponse;
import org.bank.demo.entites.Transaction;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TransactionMapper {
    CreateTransactionResponse toResponse(Transaction model);
    Transaction toEntity(CreateTransactionRequest source);
}
