package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Listino;
import it.unicam.cs.SmartChaletUnicam.Ombrellone;
import it.unicam.cs.SmartChaletUnicam.Ordinazione;
import it.unicam.cs.SmartChaletUnicam.Prodotto;
import it.unicam.cs.SmartChaletUnicam.db.MongoDB;

import java.time.LocalDateTime;
import java.util.*;

public class BarController {
    private MongoDB mongo;
    private ArrayList<Ordinazione> listaOrdinazioni;
    private Listino listino;
    private static String idOrdinazione;

    public BarController(){
        this.mongo = new MongoDB();
        this.listaOrdinazioni = mongo.dbGetAllOrdinazioni();
        this.listino = mongo.dbGetListino();
    }

    public void stampaListino() {
        for(Prodotto prodotto : this.listino.getListaProdotti()) {
            System.out.println(prodotto.toString());
        }
    }

    public void stampaOrdinazioni() {
        for(Ordinazione ordinazione : this.listaOrdinazioni) {
            for(Map.Entry<String, Integer> prodotto : ordinazione.getListaProdotti().entrySet()) {
                System.out.println(prodotto.getKey() + ": " + prodotto.getValue());
            }
            System.out.println();
        }
    }

    public void accettaOrdinazione(String ID){
        for(Ordinazione ordinazione : this.listaOrdinazioni) {
            if(ordinazione.getID().equals(ID)) {
                ordinazione.setStato(1);
                this.mongo.dbSetOrdinazione(ordinazione);
            }
        }
    }

    public void nuovaOrdinazione(int idOmbrellone) {
        int i;
        int quantita;
        Date orarioOrdinazione = new Date();
        Ordinazione ordine =
                new Ordinazione("", idOmbrellone, orarioOrdinazione, new HashMap<>(), 0.0, 0);
        Scanner reader = new Scanner(System.in);
        listino.mostraProdotti();
        do{
            do {
                System.out.print("codice prodotto: ");
                i = reader.nextInt();
            } while (i < 0 || i >= (this.listino.getListaProdotti().size() - 1));
            System.out.println("quantita: ");
            quantita = reader.nextInt();
            ordine.aggiungiProdotto(this.listino.getListaProdotti().get(i).getID(),quantita);
        }while(!reader.next().equals("*"));
        ordine.setPrezzoTotale(this.calcolaPrezzo(ordine.getListaProdotti()));
        String id = this.mongo.dbAddOrdinazione(ordine);
        ordine.setID(id);
        this.listaOrdinazioni.add(ordine);
    }

    private double calcolaPrezzo(Map<String, Integer> listaProdotti) {
        double prezzo = 0;
        for(Map.Entry<String, Integer> prodotto : listaProdotti.entrySet()) {
            prezzo += ((this.listino.getProdotto(prodotto.getKey()).getPrezzo()) * prodotto.getValue());
        }
        return prezzo;
    }

    private int scanQR(Ombrellone ombrellone) {
        return ombrellone.getID();
    }

    /*
    public void editOrdinazione(Ordinazione ordine){
        Scanner reader = new Scanner(System.in);
        String idProdotto;
        int quantita;
        do{
            System.out.println("codice prodotto");
            idProdotto = reader.next();
            System.out.println("quantita'");
            quantita = reader.nextInt();

            ordine.editProdotto(idProdotto,quantita);
        }while(!reader.next().equals("*"));
    }
     */

    public void modificaPrezzi(String id, double nuovoPrezzo){
      if(this.listino.getListaProdotti().contains(this.listino.getProdotto(id)))
        this.listino.getProdotto(id).setPrezzo(nuovoPrezzo);
    }

    /*
    public void notificaChalet(){
        Scanner reader = new Scanner(System.in);
        String notifica;
        System.out.println("Digitare il messaggio");
        notifica = reader.next();
        //invio della notifica da parte del sistema
    }
     */

    public void gestionePagamento(){
        //TODO
    }
}
