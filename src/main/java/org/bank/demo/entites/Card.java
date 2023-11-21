package org.bank.demo.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Account account;
    private Currency currency;
    private Double balance;
    private LocalDate dateCreateCard;
    private LocalDate dateCloseCard;

    public Card() {
    }

    public Card(Account account, Currency currency) {
        this.account = account;
        this.currency = currency;
    }

    @PrePersist
    public void init(){
        this.dateCreateCard = LocalDate.now();
        this.balance = 1000.0;
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
