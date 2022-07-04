package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Model.Ordinazione;
import it.unicam.cs.SmartChaletUnicam.Model.Prodotto;
import it.unicam.cs.SmartChaletUnicam.Service.ServiceBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "smartchaletunicam/bar")
public class ControllerBar {

    @Autowired
    private ServiceBar serviceBar;

    @GetMapping("/getprodotti")
    public List<Prodotto> getProdotti(){
        return serviceBar.getProdotti();
    }

    @GetMapping("/getprodotto")
    public Prodotto getProdotto(Prodotto prodotto) {
        return serviceBar.getProdotto(prodotto);
    }

    @PostMapping("/createprodotto")
    public Prodotto createProdotto(@RequestBody Prodotto prodotto) {
        return serviceBar.createProdotto(prodotto);
    }

    @PutMapping("/editprodotto")
    public Prodotto editProdotto(@RequestBody Prodotto prodotto) {
        return serviceBar.editProdotto(prodotto);
    }

    @DeleteMapping("/removeprodotto")
    public boolean removeProdotto(@RequestBody Prodotto prodotto) {
        return serviceBar.removeProdotto(prodotto);
    }

    @GetMapping("/getordinazioni")
    public List<Ordinazione> getOrdinazioni(){
        return serviceBar.getOrdinazioni();
    }

    @PostMapping("/createordinazione")
    public Ordinazione createOrdinazione(@RequestBody Ordinazione ordinazione) {
        return serviceBar.createOrdinazione(ordinazione);
    }

    @PutMapping("/editordinazione")
    public Ordinazione editOrdinazione(@RequestBody Ordinazione ordinazione) {
        return serviceBar.editOrdinazione(ordinazione);
    }

}