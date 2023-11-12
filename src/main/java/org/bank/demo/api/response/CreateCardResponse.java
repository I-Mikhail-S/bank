package org.bank.demo.api.response;

import lombok.Builder;
import lombok.Data;


public class CreateCardResponse {
    private Long id;

    public CreateCardResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
