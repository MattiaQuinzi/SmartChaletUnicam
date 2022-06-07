package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Attivita;
import it.unicam.cs.SmartChaletUnicam.db.MongoDB;

import java.util.ArrayList;
import java.util.Scanner;

public class AttivitaController {

    private ArrayList<Attivita> listaAttivita;
    private MongoDB mongo;

    public AttivitaController() {
        mongo = new MongoDB();
        this.listaAttivita = this.mongo.dbGetAllAttivita();
    }

    public void visualizzaAttivita(){
        for(Attivita attivita: this.listaAttivita){
            System.out.println(attivita.toString());
        }
    }

    public void modificaAttivita(String ID){
        Scanner reader = new Scanner(System.in);
        for(Attivita attivita : this.listaAttivita) {
            if(attivita.getID().equals(ID)) {
                String nome = reader.nextLine();
                String descrizione = reader.next();
                attivita.setNome(nome);
                attivita.setDescrizione(descrizione);
                this.mongo.dbSetAttivita(attivita);
            }
        }
    }

    public void prenotazioneAttivita(String idCliente, String idAttivita){
        for(Attivita attivita : this.listaAttivita) {
            if(attivita.getID().equals(idAttivita)) {
                attivita.getListaClienti().add(idCliente);
                this.mongo.dbSetAttivita(attivita);
            }
        }
    }

    /*
    private int getIndexOfAttivita(String id){
        for(int i=0; i<this.listaAttivita.size(); i++){
            if(this.listaAttivita.get(i).getID().equals(id))
                return i;
        }
        return -1;
    }
     */
}
