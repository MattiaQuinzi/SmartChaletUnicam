package it.unicam.cs.SmartChaletUnicam;

import java.util.ArrayList;
import java.util.Date;

public class Attivita {

    private String ID;
    private String nome;
    private String descrizione;
    private Date data;
    private ArrayList<String> listaClienti;

    public Attivita(String ID, String nome, String descrizione, Date data, ArrayList<String> listaClienti) {
        this.ID = ID;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.listaClienti = listaClienti;
    }

    public String getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Date getData() {
        return data;
    }

    public ArrayList<String> getListaClienti() {
        return listaClienti;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void addCliente(String ID) {
        this.listaClienti.add(ID);
    }

    public void removeCliente(String ID) {
        this.listaClienti.remove(ID);
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome()
                + " - Descrizione: " + this.getDescrizione()
                + " - Data: " + this.getData().toString()
                + " - Clienti: " + this.listaClienti.toString();
    }
}
