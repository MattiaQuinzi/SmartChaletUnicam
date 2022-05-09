package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Attivita;

import java.util.ArrayList;
import java.util.Scanner;

public class AttivitaController {

    private final ArrayList<Attivita> listaAttivita;

    public AttivitaController() {
        this.listaAttivita = new ArrayList<>();
        //chiamata backend per setting di attivita'
    }

    public void visualizzaAttivita(){
        for(Attivita attivita: this.listaAttivita){
            System.out.println(attivita.toString());
        }
    }

    public void modificaAttivita(int ID){
        Scanner reader = new Scanner(System.in);
        Attivita attivita = listaAttivita.get(ID+1);
        attivita.setNome(reader.next());
        attivita.setDescrizione(reader.nextLine());
        //modifica data
        //update attivita
    }
}
