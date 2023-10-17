package org.bank.demo.repositories;

import org.bank.demo.entites.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
