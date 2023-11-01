package org.bank.demo.servises;

import org.bank.demo.entites.Card;
import org.bank.demo.entites.Transaction;
import org.bank.demo.repositories.CardRepository;
import org.bank.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        Optional<Card> cardSender = cardRepository.findById(transaction.getSenderId());
        Optional<Card> cardRecipient = cardRepository.findById(transaction.getRecipientId());

        if (cardSender.isPresent() && cardRecipient.isPresent() ) {
            cardSender.get().setBalance(cardSender.get().getBalance() - transaction.getMoney());
            cardRecipient.get().setBalance(cardRecipient.get().getBalance() + transaction.getMoney());
        } else
            throw new RuntimeException("Пустая карта!");

        cardRepository.save(cardSender.get());
        cardRepository.save(cardRecipient.get());

        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> getInfoTransaction(Long id) {
        return transactionRepository.findById(id);
    }

}
