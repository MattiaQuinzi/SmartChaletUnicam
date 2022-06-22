package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Ombrellone;
import it.unicam.cs.SmartChaletUnicam.Prenotazione;
import it.unicam.cs.SmartChaletUnicam.db.MongoDB;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SpiaggiaController {
    private ArrayList<Ombrellone> listaOmbrelloni;
    private ArrayList<Prenotazione> listaPrenotazioni;
    private int lettiniDisponibili, sdraioDisponibili;
    private double prezzoLettino, prezzoSdraio, prezzoOmbrellone;
    private MongoDB mongo;

    public SpiaggiaController(){
        this.mongo = new MongoDB();
        ArrayList<Double> valoriSpiaggia = this.mongo.dbGetValoriSpiaggia();
        this.listaOmbrelloni = this.mongo.dbGetListaOmbrelloni();
        this.listaPrenotazioni = this.mongo.dbGetListaPrenotazioni();
        this.prezzoOmbrellone = valoriSpiaggia.get(0);
        this.prezzoLettino = valoriSpiaggia.get(1);
        this.prezzoSdraio = valoriSpiaggia.get(2);
        this.lettiniDisponibili = valoriSpiaggia.get(3).intValue();
        this.sdraioDisponibili = valoriSpiaggia.get(4).intValue();
    }

    public void modificaOmbrellone(int ID){
        Scanner reader = new Scanner(System.in);
        Ombrellone ombrellone = listaOmbrelloni.get(ID+1);
        ombrellone.setNumLettini(reader.nextInt());
        ombrellone.setNumSdraio(reader.nextInt());
        this.calcolaPrezzo(ombrellone);
        // scalare la disponibilita'
        //update ombrellone nel database
    }

    private double calcolaPrezzo(Ombrellone ombrellone) {
        return this.prezzoOmbrellone+(ombrellone.getNumSdraio()*this.prezzoSdraio)
                +(ombrellone.getNumLettini()*this.prezzoSdraio);
    }

    public void visualizzaSpiaggia(){
        for(Ombrellone ombrellone: this.listaOmbrelloni){
            System.out.println(ombrellone.toString());
        }
    }

    public ArrayList<Ombrellone> getListaOmbrelloni() {
        return listaOmbrelloni;
    }

    public void prenotazioneOmbrellone(){
        Scanner reader = new Scanner(System.in);
        Date data_inizio = new Date(), data_fine = new Date();
        int primoOmbrellone, ultimoOmbrellone;
        ArrayList<Ombrellone> listaOmbrelloni = new ArrayList<>();
    /*    do{
            //TODO INPUT DATI PRENOTAZIONE

            if(verificaDisponibilita(primoOmbrellone,ultimoOmbrellone)){
                Prenotazione prenotazione =
                        new Prenotazione(idPrenotazione++,data_inizio,data_fine,listaOmbrelloni);
                this.listaPrenotazioni.add(prenotazione);
                break;
            }
        }while(true);*/
    }

    private Date setData(int giorno, int mese){
        return null;
        //TODO
    }

    private boolean verificaDisponibilita(int primoOmbrellone, int ultimoOmbrellone) {
        for(Ombrellone ombrellone: this.listaOmbrelloni){
            if(ombrellone.getID()>=primoOmbrellone
                    && ombrellone.getID()<=ultimoOmbrellone
                        && (ombrellone.getStato() != null || ombrellone.getStato() != "")){
                return false; //ombrellone occupato
            }
        }
        return true;
    }

    public void modificaPrenotazione(){
        Scanner reader = new Scanner(System.in);
        Date data_inizio = new Date(), data_fine = new Date();
        int primoOmbrellone, ultimoOmbrellone, id_Prenotazione = 0;
        ArrayList<Ombrellone> listaOmbrelloni = new ArrayList<>();

        System.out.println("Inserire codice prenotazione");
        id_Prenotazione = reader.nextInt();

          // da terminare

    }



    public void verificaPrenotazione(){
        //TODO
        //la prenotazione non ha clienti assegnati
    }
}



