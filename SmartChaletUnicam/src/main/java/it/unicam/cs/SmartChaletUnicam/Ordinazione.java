package it.unicam.cs.SmartChaletUnicam;

import java.util.Date;
import java.util.Map;

public class Ordinazione {

    private String ID;
    private int idOmbrellone;
    private Date orario;
    private Map<String, Integer> listaProdotti;
    private double prezzoTotale;
    private int stato; // 0-non 1-in elaborazione 2-finito

    public Ordinazione(String ID, int idOmbrellone, Date orario, Map<String, Integer> listaProdotti, double prezzoTotale, int stato) {
        this.ID = ID;
        this.idOmbrellone = idOmbrellone;
        this.orario = orario;
        this.listaProdotti = listaProdotti;
        this.prezzoTotale = prezzoTotale;
        this.stato = stato;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getIdOmbrellone() {
        return idOmbrellone;
    }

    public Date getOrario() {
        return orario;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public int getStato() {
        return stato;
    }

    public Map<String, Integer> getListaProdotti() {
        return listaProdotti;
    }

    public void aggiungiProdotto(String idProdotto, int quantita){
        this.listaProdotti.put(idProdotto, quantita);
    }

    public void editProdotto(String id, int nuovaQuantita){
        if(this.listaProdotti.containsKey(id)){
            this.listaProdotti.replace(id,nuovaQuantita);
        }
    }
}
