package org.bank.demo.api.request;

import lombok.Builder;
import lombok.Data;

public class CreateCardRequest {
    private Long accountId;

    public CreateCardRequest() {
    }

    public CreateCardRequest(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
