package org.bank.demo.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.bank.demo.entites.Currency;


public class CreateTransactionResponse {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Currency currency;
    private Double money;
    private Long senderId;
    private Long recipientId;

    public CreateTransactionResponse() {
    }

    public CreateTransactionResponse(Long id, Currency currency, Double money, Long senderId, Long recipientId) {
        this.id = id;
        this.currency = currency;
        this.money = money;
        this.senderId = senderId;
        this.recipientId = recipientId;
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }
}
