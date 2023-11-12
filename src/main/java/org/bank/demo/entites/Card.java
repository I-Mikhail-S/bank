package org.bank.demo.entites;

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
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;
    private Double balance;
    private LocalDate dateCreateCard;
    private LocalDate dateCloseCard;

    public Card() {
    }

    public Card (Account account){
        this.account = account;
    }
    @PrePersist
    public void init(){
        this.dateCreateCard = LocalDate.now();
        this.balance = 1000.0;
        this.dateCloseCard = dateCreateCard.plusYears(4);
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
