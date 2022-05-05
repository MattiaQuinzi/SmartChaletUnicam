package it.unicam.cs.SmartChaletUnicam;

public class Ombrellone {

    private int ID;
    private int numLettini;
    private int numSdraio;

    public Ombrellone(int ID) {
        this.ID = ID;
        this.numLettini = 1;
        this.numSdraio = 1;
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
}
