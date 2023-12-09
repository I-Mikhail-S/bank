package org.bank.demo.servises;

import org.bank.demo.api.response.CreateCardResponse;
import org.bank.demo.entites.Account;
import org.bank.demo.entites.Card;
import org.bank.demo.entites.Currency;
import org.bank.demo.exception.NotFoundAccountException;
import org.bank.demo.exception.NotFoundCardException;
import org.bank.demo.mapper.CardMapper;
import org.bank.demo.repositories.AccountRepository;
import org.bank.demo.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    public CreateCardResponse createCard(Long accountId, Currency currency) {
        Optional<Account> accountOptional = Optional.ofNullable(accountRepository.findById(accountId).orElseThrow(
                () -> new NotFoundAccountException("Нет аккаунта с таким ID!")
        ));
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();// Извлекаем значение из Optional
            Set<Card> cards = new HashSet<>(account.getCards());
            Card card = new Card(account, currency);
            cards.add(card);
            account.setCards(cards);
            accountRepository.save(account); // Сохраняем аккаунт
            cardRepository.save(card);// Сохраняем карту
            return cardMapper.toResponse(card);
        }
        return null;
    }

    public CreateCardResponse getCard(Long id) {
        Optional<Card> card = Optional.of(cardRepository.findById(id).orElseThrow(
                () -> new NotFoundCardException("Нет карты с таким ID!")
        ));
        return cardMapper.toResponse(card.get());
    }

/*    @Transactional
    public CreateCardResponse updateBalance(Long cardId, Currency currency, Double money) {
        Optional<Card> card = cardRepository.findById(cardId);
        if (card.isPresent()) {

        }
    }*/
}
