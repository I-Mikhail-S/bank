package org.bank.demo.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.bank.demo.entites.Currency;

@Data
@Builder
public class CreateTransactionResponse {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Currency currency;
    private Double money;
    private Long senderId;
    private Long recipientId;


}
