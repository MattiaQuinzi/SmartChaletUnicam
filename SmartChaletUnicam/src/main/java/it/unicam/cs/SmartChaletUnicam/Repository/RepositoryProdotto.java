package it.unicam.cs.SmartChaletUnicam.Repository;

import it.unicam.cs.SmartChaletUnicam.Model.Prodotto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProdotto extends MongoRepository<Prodotto, String> {}