package org.bank.demo.controllers;


import org.bank.demo.api.request.CreateCardRequest;
import org.bank.demo.api.response.CreateCardResponse;
import org.bank.demo.servises.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/admin/card")
public class CardController {
    private final CardService cardService;
    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/create")
    public CreateCardResponse createCard(@RequestBody CreateCardRequest request) {
        return cardService.createCard(request.getAccountId(), request.getCurrency());
    }
}
