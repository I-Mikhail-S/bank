package org.bank.demo.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bank.demo.entites.Account;

public class LoginResponse {
    private Account account;
    private String jwt;

    public LoginResponse() {
    }

    public LoginResponse(Account account, String jwt) {
        this.account = account;
        this.jwt = jwt;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
