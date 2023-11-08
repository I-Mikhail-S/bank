package org.bank.demo.controllers;


import org.bank.demo.api.response.CreateCardResponse;
import org.bank.demo.servises.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/card/")
public class CardController {

    @Autowired
    private CardService cardService;
    @PostMapping("/create")
    public CreateCardResponse createCard(Long accountId) {
        return cardService.createCard(accountId);
    }
}
