package it.unicam.cs.SmartChaletUnicam;

public class Ombrellone {

    private int ID;
    private int numLettini;
    private int numSdraio;
    private String stato; //"" => libero, "unavailable" => non disponibile, "id di un cliente" => occupato da quel cliente
    private double costo;

    public Ombrellone(int ID) {
        this.ID = ID;
        this.numLettini = 1;
        this.numSdraio = 1;
        this.stato = "";
        this.costo = 0;
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

    public String getStato() {
        return stato;
    }

    public void setNumLettini(int numLettini) {
        this.numLettini = numLettini;
    }

    public void setNumSdraio(int numSdraio) {
        this.numSdraio = numSdraio;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "ID: " + this.getID() + " - Lettini: "
                + this.getNumLettini() + " - Sdraio: "
                + this.getNumSdraio() + " - Costo: "
                + this.getCosto();
    }
}