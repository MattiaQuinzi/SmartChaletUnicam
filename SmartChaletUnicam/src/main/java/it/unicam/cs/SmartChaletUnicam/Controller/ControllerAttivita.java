package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Model.Attivita;
import it.unicam.cs.SmartChaletUnicam.Service.ServiceAttivita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "smartchaletunicam/attivita")
public class ControllerAttivita {

    @Autowired
    private ServiceAttivita serviceAttivita;

    @GetMapping("/getlistaattivita")
    public List<Attivita> getListaAttivita(){
        return serviceAttivita.getListaAttivita();
    }

    @GetMapping("/getattivita")
    public Attivita getAttivita(@RequestBody Attivita attivita) {
        return serviceAttivita.getAttivita(attivita);
    }

    @PostMapping("/createattivita")
    public Attivita createAttivita(@RequestBody Attivita attivita) {
        return serviceAttivita.createAttivita(attivita);
    }

    @PutMapping("/editattivita")
    public Attivita editAttivita(@RequestBody Attivita attivita) {
        return serviceAttivita.editAttivita(attivita);
    }

    @DeleteMapping("/removeattivita")
    public boolean removeAttivita(@RequestBody Attivita attivita) {
        return serviceAttivita.removeAttivita(attivita);
    }

}
