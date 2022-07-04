package it.unicam.cs.SmartChaletUnicam.Repository;

import it.unicam.cs.SmartChaletUnicam.Model.GestioneSpiaggia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryGestioneSpiaggia extends MongoRepository<GestioneSpiaggia, String> {
}
