package it.unicam.cs.SmartChaletUnicam;

import java.util.Date;

public class Prenotazione {

    private int ID;
    private Date data;
    private Ombrellone [] listaOmbrelloni;

    public Prenotazione(int ID, Date data, Ombrellone [] listaOmbrelloni) {
        this.ID = ID;
        this.data = data;
        this.listaOmbrelloni = listaOmbrelloni;
    }

    public int getID() {
        return this.ID;
    }

    public Date getData() {
        return this.data;
    }

    public Ombrellone[] getListaOmbrelloni() {
        return this.listaOmbrelloni;
    }
}
