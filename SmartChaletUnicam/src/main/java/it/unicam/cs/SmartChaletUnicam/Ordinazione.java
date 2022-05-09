package it.unicam.cs.SmartChaletUnicam;

import java.time.LocalDateTime;
import java.util.Map;

public class Ordinazione {

    private int ID, ID_Ombrellone;
    private LocalDateTime orario;
    private Map<Integer, Integer> listaProdotti;
    private double prezzoTotale;
    private int stato;

    public Ordinazione(int ID, int ID_Ombrellone, LocalDateTime orario, Map<Integer, Integer> listaProdotti, double prezzoTotale) {
        this.ID = ID;
        this.ID_Ombrellone = ID_Ombrellone;
        this.orario = orario;
        this.listaProdotti = listaProdotti;
        this.prezzoTotale = 2;
        this.stato = 0;
    }

    private int calcolaPrezzo() {
        int prezzo = 0;
        return prezzo;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public int getStato() {
        return stato;
    }
}
