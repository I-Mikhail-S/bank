package org.bank.demo.servises;

import org.bank.demo.api.request.CreateTransactionRequest;
import org.bank.demo.api.response.CreateTransactionResponse;
import org.bank.demo.entites.Card;
import org.bank.demo.entites.Transaction;
import org.bank.demo.mapper.TransactionMapper;
import org.bank.demo.repositories.CardRepository;
import org.bank.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Console;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CardRepository cardRepository;
    private final TransactionMapper transactionMapper;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, CardRepository cardRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.cardRepository = cardRepository;
        this.transactionMapper = transactionMapper;
    }

    @Transactional
    public CreateTransactionResponse createTransaction(CreateTransactionRequest request) {
        Optional<Card> cardSender = cardRepository.findById(request.getSenderId());
        Optional<Card> cardRecipient = cardRepository.findById(request.getRecipientId());
        Transaction transaction = transactionMapper.toEntity(request);

        if (cardSender.isPresent() && cardRecipient.isPresent() ) {
            cardSender.get().setBalance(cardSender.get().getBalance() - request.getMoney());
            cardRecipient.get().setBalance(cardRecipient.get().getBalance() + request.getMoney());
        } else
            throw new RuntimeException("Пустая карта!");
        cardRepository.save(cardSender.get());
        cardRepository.save(cardRecipient.get());
        transactionRepository.save(transaction);
        return transactionMapper.toResponse(transaction);
    }

    public Optional<Transaction> getInfoTransaction(Long id) {
        return transactionRepository.findById(id);
    }

}
