package it.unicam.cs.SmartChaletUnicam;

import java.util.ArrayList;
import java.util.Date;

public class Prenotazione {

    private String ID;
    private String idCliente;
    private Date dataInizio;
    private Date dataFine;
    private ArrayList<Ombrellone> listaOmbrelloni;

    public Prenotazione(String ID, String idCliente, Date dataInizio, Date dataFine, ArrayList<Ombrellone> listaOmbrelloni) {
        this.ID = ID;
        this.idCliente = idCliente;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.listaOmbrelloni = listaOmbrelloni;
    }

    public String getID() {
        return this.ID;
    }

    public Date getInizio() {
        return this.dataInizio;
    }

    public Date getFine() {
        return dataFine;
    }

    public void setInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public ArrayList<Ombrellone> getOmbrelloni() {
        return this.listaOmbrelloni;
    }

    public void addOmbrellone(Ombrellone ombrellone) {
        this.listaOmbrelloni.add(ombrellone);
    }

    public void removeOmbrellone(int ID) {
        for(Ombrellone omb: this.listaOmbrelloni) {
            if(omb.getID() == ID)
                this.listaOmbrelloni.remove(omb);
        }
    }

}
