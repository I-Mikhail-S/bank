package org.bank.demo.mapper;

import org.bank.demo.api.request.CreateAccountRequest;
import org.bank.demo.api.response.CreateAccountResponse;
import org.bank.demo.entites.Account;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AccountMapper {
    CreateAccountResponse toResponse(Account model);
    Account toEntity(CreateAccountRequest source);
}
