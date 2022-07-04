package it.unicam.cs.SmartChaletUnicam.Repository;

import it.unicam.cs.SmartChaletUnicam.Model.Ombrellone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOmbrellone extends MongoRepository<Ombrellone, String> {}
