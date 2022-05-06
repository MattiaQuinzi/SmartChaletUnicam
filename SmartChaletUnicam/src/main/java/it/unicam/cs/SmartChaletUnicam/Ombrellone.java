package it.unicam.cs.SmartChaletUnicam;

public class Ombrellone {

    private int ID;
    private int numLettini;
    private int numSdraio;
    private int stato;

    public Ombrellone(int ID) {
        this.ID = ID;
        this.numLettini = 1;
        this.numSdraio = 1;
        this.stato = 0;
    }

    public int getID() {
        return this.ID;
    }

    public int getNumLettini() {
        return this.numLettini;
    }

    public int getNumSdraio() {
        return this.numSdraio;
    }

    public int getStato() {
        return stato;
    }

    public void setNumLettini(int numLettini) {
        this.numLettini = numLettini;
    }

    public void setNumSdraio(int numSdraio) {
        this.numSdraio = numSdraio;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

}
