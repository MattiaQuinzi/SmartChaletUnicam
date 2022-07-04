package it.unicam.cs.SmartChaletUnicam.Service;

import it.unicam.cs.SmartChaletUnicam.Model.Ordinazione;
import it.unicam.cs.SmartChaletUnicam.Model.Prodotto;
import it.unicam.cs.SmartChaletUnicam.Repository.RepositoryProdotto;
import it.unicam.cs.SmartChaletUnicam.Repository.RepositoryOrdinazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ServiceBar {

    @Autowired
    private RepositoryProdotto repositoryProdotto;

    @Autowired
    private RepositoryOrdinazione repositoryOrdinazione;

    public List<Prodotto> getProdotti(){
        return repositoryProdotto.findAll();
    }

    public Prodotto getProdotto(Prodotto prodotto) {
        if(repositoryProdotto.existsById(prodotto.getId())) {
            return repositoryProdotto.findById(prodotto.getId()).get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "prodotto non presente");
        }
    }

    public Prodotto createProdotto(Prodotto prodotto) {
        return repositoryProdotto.insert(prodotto);
    }

    public Prodotto editProdotto(Prodotto prodotto) {
        repositoryProdotto.deleteById(prodotto.getId());
        return repositoryProdotto.insert(prodotto);
    }

    public boolean removeProdotto(Prodotto prodotto) {
        if(repositoryProdotto.existsById(prodotto.getId())) {
            repositoryProdotto.deleteById(prodotto.getId());
            return true;
        } else {
            return false;
        }
    }

    public List<Ordinazione> getOrdinazioni(){
        return repositoryOrdinazione.findAll();
    }

    public Ordinazione createOrdinazione(Ordinazione ordinazione) {
        return repositoryOrdinazione.insert(ordinazione);
    }

    public Ordinazione editOrdinazione(Ordinazione ordinazione) {
        if(repositoryOrdinazione.existsById(ordinazione.getId())) {
            repositoryOrdinazione.deleteById(ordinazione.getId());
            return repositoryOrdinazione.insert(ordinazione);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ordinazione non presente");
        }
    }


}
