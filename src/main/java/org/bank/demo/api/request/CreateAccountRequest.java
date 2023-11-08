package org.bank.demo.api.request;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class CreateAccountRequest {
    private String name;
    private Long telephone;
    private String email;
    private LocalDate dateOfBirth;
}
