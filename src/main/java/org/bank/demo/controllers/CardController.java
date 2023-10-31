package org.bank.demo.controllers;


import org.bank.demo.servises.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.bank.demo.entites.Card;

import java.util.Optional;


@RestController
@RequestMapping("api/card/")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<?> createCard(Card card) {
        Optional<Card> card1 = cardService.createCard(card);
        return new ResponseEntity<>(card1, HttpStatus.CREATED);
    }

}
