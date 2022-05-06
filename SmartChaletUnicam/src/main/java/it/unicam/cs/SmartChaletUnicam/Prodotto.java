package it.unicam.cs.SmartChaletUnicam;

public class Prodotto {

    private int ID;
    private String nome;
    private double prezzo;

    public Prodotto(int ID, String nome, double prezzo) {
        this.ID = ID;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
