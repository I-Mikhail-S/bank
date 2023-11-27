package org.bank.demo.api.request;

import lombok.Builder;
import lombok.Data;
import org.bank.demo.entites.Currency;

public class CreateCardRequest {
    private Long accountId;
    private Currency currency;

    public CreateCardRequest() {
    }

    public CreateCardRequest(Long accountId, Currency currency) {
        this.accountId = accountId;
        this.currency = currency;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
