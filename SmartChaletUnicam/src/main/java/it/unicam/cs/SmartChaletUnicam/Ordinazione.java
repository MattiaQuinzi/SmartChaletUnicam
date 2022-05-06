package it.unicam.cs.SmartChaletUnicam;

import java.time.LocalDateTime;
import java.util.Map;

public class Ordinazione {

    private int ID;
    private LocalDateTime orario;
    private Map<Integer, Integer> listaProdotti;
    private double prezzoTotale;

    public Ordinazione(int ID, LocalDateTime orario, Map<Integer, Integer> listaProdotti, double prezzoTotale) {
        this.ID = ID;
        this.orario = orario;
        this.listaProdotti = listaProdotti;
        this.prezzoTotale = 2;
    }

    private int calcolaPrezzo() {
        int prezzo = 0;
        return prezzo;
    }
}
