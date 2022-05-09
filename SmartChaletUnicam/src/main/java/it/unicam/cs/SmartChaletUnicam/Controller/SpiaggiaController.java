package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Ombrellone;

import java.util.ArrayList;
import java.util.Scanner;

public class SpiaggiaController {
    private ArrayList<Ombrellone> listaOmbrelloni ;
    private int lettiniDisponibili, sdraioDisponibili; //nel magazzino

    public SpiaggiaController(){
        this.listaOmbrelloni = new ArrayList<>();
        // chiamata al database per ombrelloni
        // chiamata al database per sraio e lettini
    }

    public void editOmbrellone(int ID){
        Scanner reader = new Scanner(System.in);
        Ombrellone ombrellone = listaOmbrelloni.get(ID+1);
        ombrellone.setNumLettini(reader.nextInt());
        ombrellone.setNumSdraio(reader.nextInt());
        // scalare la disponibilita'

        this.calcolaPrezzo(ombrellone);

        //update ombrellone
    }

    private void calcolaPrezzo(Ombrellone ombrellone) {
        //TODO
    }

    public void visualizzaSpiaggia(){
        for(Ombrellone ombrellone: this.listaOmbrelloni){
            System.out.println(ombrellone.toString());
        }
    }

    public ArrayList<Ombrellone> getListaOmbrelloni() {
        return listaOmbrelloni;
    }
}
