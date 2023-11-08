package org.bank.demo.servises;

import org.bank.demo.api.response.CreateCardResponse;
import org.bank.demo.entites.Account;
import org.bank.demo.entites.Card;
import org.bank.demo.mapper.CardMapper;
import org.bank.demo.repositories.AccountRepository;
import org.bank.demo.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CardService {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final CardMapper cardMapper;
    @Autowired
    public CardService(CardRepository cardRepository, AccountRepository accountRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
        this.cardMapper = cardMapper;
    }




    @Transactional
    public CreateCardResponse createCard(Long accountId) {
        System.out.println(accountId);
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();// Извлекаем значение из Optional
            Card card = new Card(account);
            accountRepository.save(account); // Сохраняем аккаунт
            cardRepository.save(card);// Сохраняем карту
            return cardMapper.toResponse(card);
        }
        return null;
    }
}
