package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Listino;
import it.unicam.cs.SmartChaletUnicam.Ordinazione;

import java.util.ArrayList;

public class BarController {
    private ArrayList<Ordinazione> listaOrdinazioni;
    private Listino listino;

    public BarController(){
        listaOrdinazioni = new ArrayList<>();
        //chiamata backend per il settaggio
    }

    public void accettaOrdinazione(int ID){
        this.listaOrdinazioni.get(ID+1).setStato(1);
        //update database
    }



}
