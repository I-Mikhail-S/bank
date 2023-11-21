package org.bank.demo.api.response;

import lombok.Builder;
import lombok.Data;
import org.bank.demo.entites.Currency;


public class CreateCardResponse {
    private Long id;
    private Currency currency;

    public CreateCardResponse() {
    }

    public CreateCardResponse(Long id, Currency currency) {
        this.id = id;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
