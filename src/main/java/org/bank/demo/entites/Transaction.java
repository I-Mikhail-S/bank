package org.bank.demo.entites;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;
    private double money;
    @Column(name = "sendler_id")
    private Long senderId;
    @Column(name = "recipient_id")
    private Long recipientId;
    private LocalDateTime date;

    public Transaction() {
    }

    public Transaction(Currency currency, double money, Long senderId, Long recipientId) {
        this.currency = currency;
        this.money = money;
        this.senderId = senderId;
        this.recipientId = recipientId;
    }

    @PrePersist
    public void init() {
        // cразу заполняем дату проведения операции
        this.date = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Currency getCash() {
        return currency;
    }

    public void setCash(Currency currency) {
        this.currency = currency;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", cash=" + currency +
                ", money=" + money +
                ", senderId=" + senderId +
                ", recipientId=" + recipientId +
                ", date=" + date +
                '}';
    }
}