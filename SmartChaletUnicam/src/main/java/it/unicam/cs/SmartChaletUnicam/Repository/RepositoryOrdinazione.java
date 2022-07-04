package it.unicam.cs.SmartChaletUnicam.Repository;

import it.unicam.cs.SmartChaletUnicam.Model.Ordinazione;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOrdinazione extends MongoRepository<Ordinazione, String> {}
