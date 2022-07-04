package it.unicam.cs.SmartChaletUnicam.Service;

import it.unicam.cs.SmartChaletUnicam.Model.GestioneSpiaggia;
import it.unicam.cs.SmartChaletUnicam.Model.Notifica;
import it.unicam.cs.SmartChaletUnicam.Model.Ombrellone;
import it.unicam.cs.SmartChaletUnicam.Model.Prenotazione;
import it.unicam.cs.SmartChaletUnicam.Repository.RepositoryGestioneSpiaggia;
import it.unicam.cs.SmartChaletUnicam.Repository.RepositoryNotifica;
import it.unicam.cs.SmartChaletUnicam.Repository.RepositoryOmbrellone;
import it.unicam.cs.SmartChaletUnicam.Repository.RepositoryPrenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceSpiaggia {

    @Autowired
    private RepositoryOmbrellone repositoryOmbrellone;

    @Autowired
    private RepositoryPrenotazione repositoryPrenotazione;

    @Autowired
    private RepositoryGestioneSpiaggia repositoryGestioneSpiaggia;

    @Autowired
    private RepositoryNotifica repositoryNotifica;

    private final String idGestioneSpiaggia = "62af3011d8ab2f99f5c1d211";

    public List<Ombrellone> getOmbrelloni(){
        return repositoryOmbrellone.findAll();
    }

    public Ombrellone getOmbrellone(Ombrellone ombrellone) {
        if(repositoryOmbrellone.existsById(ombrellone.getId())) {
            return repositoryOmbrellone.findById(ombrellone.getId()).get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ombrellone non presente");
        }
    }

    public Ombrellone createOmbrellone(Ombrellone ombrellone) {
        return repositoryOmbrellone.insert(ombrellone);
    }

    public Ombrellone editOmbrellone(Ombrellone ombrellone) {
        if(repositoryOmbrellone.existsById(ombrellone.getId())) {
            repositoryOmbrellone.deleteById(ombrellone.getId());
            return repositoryOmbrellone.insert(ombrellone);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ombrellone non presente");
        }
    }

    public boolean removeOmbrellone(Ombrellone ombrellone) {
        if(repositoryOmbrellone.existsById(ombrellone.getId())) {
            repositoryOmbrellone.deleteById(ombrellone.getId());
            return true;
        } else {
            return false;
        }
    }

    public List<Prenotazione> getPrenotazioni(){
        return repositoryPrenotazione.findAll();
    }

    public Prenotazione getPrenotazione(Prenotazione prenotazione) {
        if(repositoryPrenotazione.existsById(prenotazione.getId())) {
            return repositoryPrenotazione.findById(prenotazione.getId()).get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "prenotazione non presente");
        }
    }

    public List<Prenotazione> getPrenotazioneByCliente(Prenotazione prenotazione) {
        return repositoryPrenotazione.findByIdCliente(prenotazione.getIdCliente());
    }
    public Prenotazione createPrenotazione(Prenotazione prenotazione) {
        for(Prenotazione prenotazioneEsistente: repositoryPrenotazione.findAll()) {
            if(prenotazione.getDataInizio().before(prenotazioneEsistente.getDataFine())) {
                if(prenotazione.getDataFine().after(prenotazioneEsistente.getDataInizio())) {
                    for(Integer numOmbr: prenotazione.getListaOmbrelloni()) {
                        for(Integer numOmbrPren: prenotazioneEsistente.getListaOmbrelloni()) {
                            if(numOmbr.equals(numOmbrPren)) {
                                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "scelta per la prenotazione non disponibile");
                            }
                        }
                    }
                }
            }
        }
        return repositoryPrenotazione.insert(prenotazione);
    }

    public Prenotazione editPrenotazione(Prenotazione prenotazione) {
        if(repositoryPrenotazione.existsById(prenotazione.getId())) {
            for(Prenotazione prenotazioneEsistente: repositoryPrenotazione.findAll()) {
                if(prenotazione.getDataInizio().before(prenotazioneEsistente.getDataFine())) {
                    if(prenotazione.getDataFine().after(prenotazioneEsistente.getDataInizio())) {
                        for(Integer numOmbr: prenotazione.getListaOmbrelloni()) {
                            for(Integer numOmbrPren: prenotazioneEsistente.getListaOmbrelloni()) {
                                if(numOmbr.equals(numOmbrPren)) {
                                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "scelta per la prenotazione non disponibile");
                                }
                            }
                        }
                    }
                }
            }
            repositoryPrenotazione.deleteById(prenotazione.getId());
            return repositoryPrenotazione.insert(prenotazione);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "prenotazione non presente");
        }
    }

    public GestioneSpiaggia getGestioneSpiaggia() {
        return repositoryGestioneSpiaggia.findById(this.idGestioneSpiaggia).get();
    }

    public GestioneSpiaggia editGestioneSpiaggia(GestioneSpiaggia gestioneSpiaggia) {
        repositoryGestioneSpiaggia.deleteById(this.idGestioneSpiaggia);
        gestioneSpiaggia.setId(this.idGestioneSpiaggia);
        return repositoryGestioneSpiaggia.insert(gestioneSpiaggia);
    }

    public List<Notifica> getNotifiche() {
        return repositoryNotifica.findAll();
    }

    public Notifica getNotifica(Notifica notifica) {
        if(repositoryNotifica.existsById(notifica.getId())) {
            return repositoryNotifica.findById(notifica.getId()).get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "notifica non presente");
        }
    }

    public Notifica createNotifica(Notifica notifica) {
        return repositoryNotifica.insert(notifica);
    }



}
