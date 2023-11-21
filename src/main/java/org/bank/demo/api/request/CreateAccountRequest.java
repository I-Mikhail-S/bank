package org.bank.demo.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bank.demo.entites.Role;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CreateAccountRequest {
    private String name;
    private Long telephone;
    private String email;
    private LocalDate dateOfBirth;
    private Set<Role> authorities;
    private String password;

    public CreateAccountRequest(String name, Long telephone, String email, LocalDate dateOfBirth, HashSet<Role> authorities, String password) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.authorities = authorities;
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

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CreateAccountRequest{" +
                "name='" + name + '\'' +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", authorities=" + authorities +
                ", password='" + password + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CreateAccountRequest() {
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
