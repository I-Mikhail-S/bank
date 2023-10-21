package org.bank.demo.repositories;

import org.bank.demo.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, Long> {
}
