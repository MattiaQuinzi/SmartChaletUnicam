package it.unicam.cs.SmartChaletUnicam.Service;

import it.unicam.cs.SmartChaletUnicam.Model.Attivita;
import it.unicam.cs.SmartChaletUnicam.Repository.RepositoryAttivita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceAttivita {

    @Autowired
    private RepositoryAttivita repositoryAttivita;

    public List<Attivita> getListaAttivita(){
        return repositoryAttivita.findAll();
    }

    public Attivita getAttivita(Attivita attivita) {
        if(repositoryAttivita.existsById(attivita.getId())) {
            return repositoryAttivita.findById(attivita.getId()).get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "attivita non presente");
        }
    }

    public Attivita createAttivita(Attivita attivita) {
        return repositoryAttivita.insert(attivita);
    }

    public Attivita editAttivita(Attivita attivita) {
        if(repositoryAttivita.existsById(attivita.getId())) {
            repositoryAttivita.deleteById(attivita.getId());
            return repositoryAttivita.insert(attivita);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "attivita non presente");
        }
    }

    public boolean removeAttivita(Attivita attivita) {
        if(repositoryAttivita.existsById(attivita.getId())) {
            repositoryAttivita.deleteById(attivita.getId());
            return true;
        } else {
            return false;
        }
    }
}
