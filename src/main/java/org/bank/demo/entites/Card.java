package org.bank.demo.entites;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    @NotNull
    private Account account;
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private Currency currency;
    @NotNull
    private Double balance;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateCreateCard;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateCloseCard;

    public Card() {
    }

    public Card(Account account, Currency currency) {
        this.account = account;
        this.currency = currency;
    }

    public Card(Account account, Currency currency, Double balance) {
        this.account = account;
        this.currency = currency;
        this.balance = balance;
    }

    @PrePersist
    public void init(){
        this.dateCreateCard = LocalDate.now();
        //this.balance = 1000.0;
        this.dateCloseCard = dateCreateCard.plusYears(4);
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

    public LocalDate getDateCreateCard() {
        return dateCreateCard;
    }

    public void setDateCreateCard(LocalDate dateCreateCard) {
        this.dateCreateCard = dateCreateCard;
    }

    public LocalDate getDateCloseCard() {
        return dateCloseCard;
    }

    public void setDateCloseCard(LocalDate dateCloseCard) {
        this.dateCloseCard = dateCloseCard;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
