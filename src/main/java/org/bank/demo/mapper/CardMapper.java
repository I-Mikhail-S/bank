package org.bank.demo.mapper;

import org.bank.demo.api.response.CreateCardResponse;
import org.bank.demo.entites.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CreateCardResponse toResponse(Card model);
}
