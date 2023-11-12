package org.bank.demo.mapper;

import org.bank.demo.api.response.CreateCardResponse;
import org.bank.demo.entites.Card;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CardMapper {
    CreateCardResponse toResponse(Card model);
}
