package org.bank.demo.controllers;


import org.bank.demo.api.request.CreateCardRequest;
import org.bank.demo.api.response.CreateCardResponse;
import org.bank.demo.servises.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("{id}")
    public ResponseEntity<?> getCard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(cardService.getCard(id), HttpStatus.OK);
    }
}
