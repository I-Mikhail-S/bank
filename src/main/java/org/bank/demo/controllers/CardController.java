package org.bank.demo.controllers;


import org.bank.demo.servises.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/card/")
public class CardController {

    @Autowired
    private CardService cardService;

}
