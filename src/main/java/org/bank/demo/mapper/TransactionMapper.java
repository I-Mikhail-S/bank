package org.bank.demo.mapper;

import org.bank.demo.api.request.CreateTransactionRequest;
import org.bank.demo.api.response.CreateTransactionResponse;
import org.bank.demo.entites.Currency;
import org.bank.demo.entites.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    CreateTransactionResponse toResponse(Transaction model);
    //@Mapping(target = "currency", source = "currency")
    Transaction toEntity(CreateTransactionRequest source);

}
