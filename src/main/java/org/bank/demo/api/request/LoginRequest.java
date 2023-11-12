package org.bank.demo.api.request;

public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest(){
        super();
    }

    public LoginRequest(String email, String password){
        super();
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String toString(){
        return "Registration info: email: " + this.email + " password: " + this.password;
    }
}
