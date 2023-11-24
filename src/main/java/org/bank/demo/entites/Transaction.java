package org.bank.demo.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;
    private double money;
    @Column(name = "sender_id")
    private Long senderId;
    @Column(name = "recipient_id")
    private Long recipientId;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime date;

    @PrePersist
    public void init() {
        // cразу заполняем дату проведения операции
        this.date = LocalDateTime.now();
    }

    public Transaction(long id, Currency currency, double money, Long senderId, Long recipientId, LocalDateTime date) {
        this.id = id;
        this.currency = currency;
        this.money = money;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Transaction() {
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
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
}
