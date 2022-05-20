package it.unicam.cs.SmartChaletUnicam;

import java.time.LocalDateTime;
import java.util.Map;

public class Ordinazione {

    private int ID, ID_Ombrellone;
    private LocalDateTime orario;
    private Map<Integer, Integer> listaProdotti;
    private double prezzoTotale;
    private int stato; // 0-non 1-in elaborazione 2-finito

    public Ordinazione(int ID, int ID_Ombrellone, LocalDateTime orario, Map<Integer, Integer> listaProdotti, double prezzoTotale) {
        this.ID = ID;
        this.ID_Ombrellone = ID_Ombrellone;
        this.orario = orario;
        this.listaProdotti = listaProdotti;
        this.prezzoTotale = 2;
        this.stato = 0;
    }

    private double calcolaPrezzo() {
        double prezzo = 0;
        return prezzo;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public int getStato() {
        return stato;
    }

    public void setID_Ombrellone(int ID_Ombrellone) {
        this.ID_Ombrellone = ID_Ombrellone;
    }

    public Map<Integer, Integer> getListaProdotti() {
        return listaProdotti;
    }

    public void aggiungiProdotto(int idProdotto, int quantita){
        this.listaProdotti.put(idProdotto, quantita);
    }

    public void editProdotto(int id, int nuovaQuantita){
        if(this.listaProdotti.containsKey(id)){
            this.listaProdotti.replace(id,nuovaQuantita);
        }
    }
}
