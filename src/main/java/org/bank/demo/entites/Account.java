package org.bank.demo.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "accounts")
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotNull
    private String email;
    @JsonIgnore
    @NotNull
    private String password;
    private String name;
    private Long telephone;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="user_role_junction",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    @NotNull
    private Set<Role> authorities;
    @JsonManagedReference
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Card> cards;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateCreateAccount;

    public Account() {
        super();
        authorities = new HashSet<>();
    }

    public Account(Long id, String name, String email, String encodedPassword, Set<Role> authorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = encodedPassword;
        this.authorities = authorities;
    }

    public Account(String name, String email, String encodedPassword, Set<Role> authorities) {
        this.name = name;
        this.email = email;
        this.password = encodedPassword;
        this.authorities = authorities;
    }

    public Account(String email, String password,
                   String name, Long telephone, Set<Role> authorities,
                   LocalDate dateOfBirth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.authorities = authorities;
        this.dateOfBirth = dateOfBirth;
    }

    public Account(String email, String password,
                   String name, Long telephone, Set<Role> authorities,
                   Set<Card> cards, LocalDate dateOfBirth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.authorities = authorities;
        this.cards = cards;
        this.dateOfBirth = dateOfBirth;
    }

    @PrePersist
    public void init(){
        // cразу заполняем дату создания
        this.dateCreateAccount = LocalDate.now();
    }

    public Set<Role> getAuthorities() {
        return this.authorities;
    }

    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // TODO Auto-generated method stub
//        return (HashSet<Role>)this.authorities;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}
