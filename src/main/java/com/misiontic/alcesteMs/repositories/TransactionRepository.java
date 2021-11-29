package com.misiontic.alcesteMs.repositories;

import com.misiontic.alcesteMs.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String>{
    List<Transaction> findByEmailOrigin(String emailOrigin);
    List<Transaction> findByEmailDestiny(String emailDestiny);
}
