package org.bank.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonIgnore
    private Account account;
    private Double balance;
    private LocalDate dateCreateCard;
    private LocalDate dateCloseCard;

    @PrePersist
    public void init(){

        this.dateCreateCard = LocalDate.now();
        this.balance = 0.0;
        this.dateCloseCard = dateCreateCard.plusYears(4);
    }

    public Card() {
    }


    public Card (Account account){
        this.account = account;
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
