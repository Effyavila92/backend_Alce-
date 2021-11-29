package com.misiontic.alcesteMs.repositories;

import com.misiontic.alcesteMs.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository <Account, String> { }
