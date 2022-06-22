package it.unicam.cs.SmartChaletUnicam;

import java.util.ArrayList;
import java.util.Date;

public class Prenotazione {

    private String ID;
    private String idCliente;
    private Date dataInizio;
    private Date dataFine;
    private ArrayList<Integer> listaOmbrelloni;

    public Prenotazione(String ID, String idCliente, Date dataInizio, Date dataFine, ArrayList<Integer> listaOmbrelloni) {
        this.ID = ID;
        this.idCliente = idCliente;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.listaOmbrelloni = listaOmbrelloni;
    }

    public String getID() {
        return this.ID;
    }

    public String getIdCliente() {
        return this.idCliente;
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

    public ArrayList<Integer> getOmbrelloni() {
        return this.listaOmbrelloni;
    }

    public void addOmbrellone(int idOmbrellone) {
        this.listaOmbrelloni.add(idOmbrellone);
    }

    public void removeOmbrellone(int ID) {
        for(int idOmbrellone: this.listaOmbrelloni) {
            if(idOmbrellone == ID)
                this.listaOmbrelloni.remove(idOmbrellone);
        }
    }

    public String toString() {
        return "idCliente: " + this.idCliente + " - dataInizio: "
                + this.dataInizio.toString() + " - dataFine: "
                + this.dataFine.toString() + " - listaOmbrelloni: "
                + this.listaOmbrelloni.toString();
    }

}
