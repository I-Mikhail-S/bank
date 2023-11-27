package org.bank.demo.servises;

import org.bank.demo.api.request.CreateTransactionRequest;
import org.bank.demo.api.response.CreateTransactionResponse;
import org.bank.demo.entites.Card;
import org.bank.demo.entites.Transaction;
import org.bank.demo.exception.NotFoundAccountException;
import org.bank.demo.exception.NotFoundCardException;
import org.bank.demo.exception.NotFoundTransactionalException;
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
        Optional<Card> cardSender = Optional.ofNullable(cardRepository.findById(request.getSenderId()).orElseThrow(
                () -> new NotFoundAccountException("Нет аккаунта с таким ID!")
        ));
        Optional<Card> cardRecipient = Optional.ofNullable(cardRepository.findById(request.getRecipientId()).orElseThrow(
                () -> new NotFoundCardException("Нет карты с таким ID!")
        ));
        Transaction transaction = transactionMapper.toEntity(request);

        if (cardSender.isPresent() && cardRecipient.isPresent()) {
            cardSender.get().setBalance(cardSender.get().getBalance() - request.getMoney());
            cardRecipient.get().setBalance(cardRecipient.get().getBalance() + request.getMoney());
            cardRepository.save(cardSender.get());
            cardRepository.save(cardRecipient.get());
        }
        transactionRepository.save(transaction);
        return transactionMapper.toResponse(transaction);
    }

    public Optional<Transaction> getInfoTransaction(Long id) {
        return Optional.ofNullable(transactionRepository.findById(id).orElseThrow(
                () -> new NotFoundTransactionalException("Нет транзакции с таким ID!")
        ));
    }

}
