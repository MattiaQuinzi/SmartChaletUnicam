package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Listino;
import it.unicam.cs.SmartChaletUnicam.Ombrellone;
import it.unicam.cs.SmartChaletUnicam.Ordinazione;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class BarController {
    private ArrayList<Ordinazione> listaOrdinazioni;
    private Listino listino;
    private static int idOrdinazione= 0;

    public BarController(){
        listaOrdinazioni = new ArrayList<>();
        //chiamata backend per il settaggio
    }

    public void accettazioneOrdinazione(int ID){
        this.listaOrdinazioni.get(ID+1).setStato(1);
        //update database
    }

    public boolean nuovaOrdinazione(Ombrellone ombrellone){
        if(sceltaProdottiUtente(ombrellone).getStato()==2)
            return true;
        else return false;
    }

    private Ordinazione sceltaProdottiUtente(Ombrellone ombrellone) {
        int idProdotto, quantita;
        LocalDateTime orarioOrdinazione = null; //sistemare
        Ordinazione ordine =
                new Ordinazione(idOrdinazione++, scanQR(ombrellone), orarioOrdinazione, new HashMap<>(), 0.0);
        //orario->null
        Scanner reader = new Scanner(System.in);

        ordine.setID_Ombrellone(scanQR(ombrellone));
        ordine.setStato(1);
        listino.mostraProdotti();
        do{
            System.out.println("codice prodotto");
            idProdotto = reader.nextInt();
            System.out.println("quantita'");
            quantita = reader.nextInt();

            ordine.aggiungiProdotto(idProdotto,quantita);
        }while(!reader.next().equals("*"));
        ordine.setStato(2);
        return ordine;
    }

    private int scanQR(Ombrellone ombrellone) {
        return ombrellone.getID();
    }

    public void editOrdinazione(Ordinazione ordine){
        Scanner reader = new Scanner(System.in);
        int idProdotto, quantita;
        do{
            System.out.println("codice prodotto");
            idProdotto = reader.nextInt();
            System.out.println("quantita'");
            quantita = reader.nextInt();

            ordine.editProdotto(idProdotto,quantita);
        }while(!reader.next().equals("*"));
    }

    public void modificaPrezzi(int id, double nuovoPrezzo){
      if(this.listino.getListaProdotti().contains(this.listino.getProdotto(id)))
        this.listino.getProdotto(id).setPrezzo(nuovoPrezzo);
    }

    public void notificaChalet(){
        Scanner reader = new Scanner(System.in);
        String notifica;
        System.out.println("Digitare il messaggio");
        notifica = reader.next();
        //invio della notifica da parte del sistema
    }

    public void gestionePagamento(){
        //TODO
    }
}
