package org.bank.demo.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long telephone;
    private String email;
    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private Card card;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirds;
    private LocalDate dateCreateAccount;

    public Account() {
    }

    @PrePersist
    public void init(){
        // cразу заполняем дату создания
        this.dateCreateAccount = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public LocalDate getDateOfBirds() {
        return dateOfBirds;
    }

    public void setDateOfBirds(LocalDate dateOfBirds) {
        this.dateOfBirds = dateOfBirds;
    }

    public LocalDate getDateCreateAccount() {
        return dateCreateAccount;
    }

    public void setDateCreateAccount(LocalDate dateCreateAccount) {
        this.dateCreateAccount = dateCreateAccount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                ", dateOfBirds=" + dateOfBirds +
                ", dateCreateAccount=" + dateCreateAccount +
                '}';
    }
}
