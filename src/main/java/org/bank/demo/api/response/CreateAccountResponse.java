package org.bank.demo.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountResponse {
    private Long id;
    private String name;
    private Long telephone;
    private String email;
    private LocalDate dateOfBirth;
}
