package org.bank.demo.controllers;

import org.bank.demo.servises.Currency.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/currency")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/getCurrency")
    public String getCurrencyExchangeRate() {
        return currencyService.getCurrency();
    }
}
