package org.bank.demo.api.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class CreateAccountResponse {
    private Long id;
    private String name;
    private Long telephone;
    private String email;
    private LocalDate dateOfBirth;
}
