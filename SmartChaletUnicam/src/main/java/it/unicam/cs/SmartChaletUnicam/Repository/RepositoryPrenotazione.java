package it.unicam.cs.SmartChaletUnicam.Repository;

import it.unicam.cs.SmartChaletUnicam.Model.Prenotazione;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPrenotazione extends MongoRepository<Prenotazione, String> {
    List<Prenotazione> findByIdCliente(String idCliente);
}
