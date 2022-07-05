package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Model.GestioneSpiaggia;
import it.unicam.cs.SmartChaletUnicam.Model.Notifica;
import it.unicam.cs.SmartChaletUnicam.Model.Ombrellone;
import it.unicam.cs.SmartChaletUnicam.Model.Prenotazione;
import it.unicam.cs.SmartChaletUnicam.Service.ServiceSpiaggia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "smartchaletunicam/spiaggia")
public class ControllerSpiaggia {

    @Autowired
    private ServiceSpiaggia serviceSpiaggia;

    @GetMapping("/getombrelloni")
    public List<Ombrellone> getOmbrelloni() {
        return serviceSpiaggia.getOmbrelloni();
    }

    @GetMapping("/getombrellone")
    public Ombrellone getOmbrellone(@RequestBody Ombrellone ombrellone) {
        return serviceSpiaggia.getOmbrellone(ombrellone);
    }

    @PostMapping("/createombrellone")
    public Ombrellone createOmbrellone(@RequestBody Ombrellone ombrellone) {
        return serviceSpiaggia.createOmbrellone(ombrellone);
    }

    @PutMapping("/editombrellone")
    public Ombrellone editOmbrellone(@RequestBody Ombrellone ombrellone) {
        return serviceSpiaggia.editOmbrellone(ombrellone);
    }

    @DeleteMapping("/removeombrellone")
    public boolean removeOmbrellone(@RequestBody Ombrellone ombrellone) {
        return serviceSpiaggia.removeOmbrellone(ombrellone);
    }

    @GetMapping("/getprenotazioni")
    public List<Prenotazione> getPrenotazioni() {
        return serviceSpiaggia.getPrenotazioni();
    }

    @GetMapping("/getprenotazione")
    public Prenotazione getPrenotazione(@RequestBody Prenotazione prenotazione) {
        return serviceSpiaggia.getPrenotazione(prenotazione);
    }

    @GetMapping("/getprenotazionebycliente")
    public List<Prenotazione> getPrenotazioneByCliente(@RequestBody Prenotazione prenotazione) {
        return serviceSpiaggia.getPrenotazioneByCliente(prenotazione);
    }

    @PostMapping("/createprenotazione")
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione) {
        return serviceSpiaggia.createPrenotazione(prenotazione);
    }

    @PutMapping("/editprenotazione")
    public Prenotazione editPrenotazione(@RequestBody Prenotazione prenotazione) {
        return serviceSpiaggia.editPrenotazione(prenotazione);
    }

    @GetMapping("/getgestionespiaggia")
    public GestioneSpiaggia getGestioneSpiaggia() {
        return serviceSpiaggia.getGestioneSpiaggia();
    }

    @PutMapping("/editgestionespiaggia")
    public GestioneSpiaggia editGestioneSpiaggia(@RequestBody GestioneSpiaggia gestioneSpiaggia) {
        return serviceSpiaggia.editGestioneSpiaggia(gestioneSpiaggia);
    }

    @GetMapping("/getnotifiche")
    public List<Notifica> getNotifiche() {
        return serviceSpiaggia.getNotifiche();
    }

    @GetMapping("/getnotifica")
    public Notifica getNotifica(@RequestBody Notifica notifica) {
        return serviceSpiaggia.getNotifica(notifica);
    }

    @PostMapping("/createnotifica")
    public Notifica createNotifica(@RequestBody Notifica notifica) {
        return serviceSpiaggia.createNotifica(notifica);
    }

}
