package org.bank.demo.servises;

import org.bank.demo.api.request.CreateTransactionRequest;
import org.bank.demo.api.response.CreateTransactionResponse;
import org.bank.demo.entites.Card;
import org.bank.demo.entites.Transaction;
import org.bank.demo.mapper.TransactionMapper;
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
    @Autowired
    private TransactionMapper transactionMapper;

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
        System.out.println(transaction.getCurrency());
        System.out.println(""+request.getMoney() + request.getCurrency());
        cardRepository.save(cardSender.get());
        cardRepository.save(cardRecipient.get());
        transactionRepository.save(transaction);
        return transactionMapper.toResponse(transaction);
    }

    public Optional<Transaction> getInfoTransaction(Long id) {
        return transactionRepository.findById(id);
    }

}
