package it.unicam.cs.SmartChaletUnicam.Repository;

import it.unicam.cs.SmartChaletUnicam.Model.Notifica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryNotifica extends MongoRepository<Notifica, String> {
}
