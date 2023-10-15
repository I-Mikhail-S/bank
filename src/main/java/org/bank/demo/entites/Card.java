package org.bank.demo.entites;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "accounts_id")
    private Account account;
    private Double balance;
    private LocalDate dateCreateCard;
    private LocalDate dateCloseCard;

    public Card() {
    }

    public Card(Account account, Double balance, LocalDate dateCreateCard, LocalDate dateCloseCard) {
        this.account = account;
        this.balance = balance;
        this.dateCreateCard = dateCreateCard;
        this.dateCloseCard = dateCloseCard;
    }

    public Card(Long id, Account account, Double balance, LocalDate dateCreateCard, LocalDate dateCloseCard) {
        this.id = id;
        this.account = account;
        this.balance = balance;
        this.dateCreateCard = dateCreateCard;
        this.dateCloseCard = dateCloseCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", account=" + account +
                ", balance=" + balance +
                ", dateCreateCard=" + dateCreateCard +
                ", dateCloseCard=" + dateCloseCard +
                '}';
    }
}
