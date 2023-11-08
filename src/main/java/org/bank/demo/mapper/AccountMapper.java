package org.bank.demo.mapper;

import org.bank.demo.api.request.CreateAccountRequest;
import org.bank.demo.api.request.CreateTransactionRequest;
import org.bank.demo.api.response.CreateAccountResponse;
import org.bank.demo.api.response.CreateTransactionResponse;
import org.bank.demo.entites.Account;
import org.bank.demo.entites.Transaction;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
@Mapper(componentModel = "spring")
public interface AccountMapper {
    CreateAccountResponse toResponse(Account model);
    Account toEntity(CreateAccountRequest source);
}
