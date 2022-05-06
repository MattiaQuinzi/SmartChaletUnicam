package it.unicam.cs.SmartChaletUnicam;

import java.util.ArrayList;

public class Listino {

    private ArrayList<Prodotto> listaProdotti;

    public Listino() {
        this.listaProdotti = new ArrayList<>();
    }

    public void addProdotto(Prodotto prodotto) {
        this.listaProdotti.add(prodotto);
    }

    public Prodotto getProdotto(int ID) {
        int index = 0;
        for(Prodotto prod : this.listaProdotti) {
            if(prod.getID() == ID)
                index = this.listaProdotti.indexOf(prod);
        }
        return listaProdotti.get(index);
    }

    public void removeProdotto(int ID) {
        for(Prodotto prod : this.listaProdotti) {
            if(prod.getID() == ID)
                this.listaProdotti.remove(prod);
        }
    }

}
