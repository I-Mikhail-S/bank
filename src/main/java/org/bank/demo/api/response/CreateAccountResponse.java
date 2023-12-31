package org.bank.demo.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bank.demo.entites.Role;

import java.time.LocalDate;
import java.util.Set;

public class CreateAccountResponse {
    private String name;
    @JsonIgnore
    private Long telephone;
    private String email;
    private Set<Role> authorities;
    @JsonIgnore
    private LocalDate dateOfBirth;
    @JsonIgnore
    private String password;

    public CreateAccountResponse(String name, Long telephone, String email, Set<Role> authorities, LocalDate dateOfBirth, String password) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.authorities = authorities;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public CreateAccountResponse() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getAuthorities() {
        return authorities;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
