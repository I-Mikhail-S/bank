package org.bank.demo.controllers;


import org.bank.demo.entites.Card;
import org.bank.demo.servises.AccountService;
import org.bank.demo.servises.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("api/card/")
public class CardController {

    @Autowired
    private CardService cardService;

}
