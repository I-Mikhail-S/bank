package org.bank.demo.api.request;

import lombok.Builder;
import lombok.Data;
import org.bank.demo.entites.Currency;

@Data
@Builder
public class CreateTransactionRequest {
    private Currency currency;
    private Double money;
    private Long senderId;
    private Long recipientId;
}
