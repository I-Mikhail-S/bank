package org.bank.demo.api.request;

import org.bank.demo.entites.Currency;


public class CreateTransactionRequest {
    private Currency currency;
    private Double money;
    private Long senderId;
    private Long recipientId;

    public CreateTransactionRequest() {
    }

    public CreateTransactionRequest(Currency currency, Double money, Long senderId, Long recipientId) {
        this.currency = currency;
        this.money = money;
        this.senderId = senderId;
        this.recipientId = recipientId;
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

    @Override
    public String toString() {
        return "CreateTransactionRequest{" +
                "currency=" + currency +
                ", money=" + money +
                ", senderId=" + senderId +
                ", recipientId=" + recipientId +
                '}';
    }
}
