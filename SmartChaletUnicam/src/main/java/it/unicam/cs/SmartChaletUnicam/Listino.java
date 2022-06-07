package it.unicam.cs.SmartChaletUnicam;

import java.util.ArrayList;

public class Listino {

    private ArrayList<Prodotto> listaProdotti;

    public Listino(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public void addProdotto(Prodotto prodotto) {
        this.listaProdotti.add(prodotto);
    }

    public Prodotto getProdotto(String ID) {
        for(Prodotto prod : this.listaProdotti) {
            if(prod.getID().equals(ID))
                return prod;
        }
        return null;
    }

    public void removeProdotto(String ID) {
        for(Prodotto prod : this.listaProdotti) {
            if(prod.getID().equals(ID))
                this.listaProdotti.remove(prod);
        }
    }

    public void mostraProdotti(){
        int i = 0;
        for(Prodotto prodotto: this.listaProdotti){
            System.out.println(i + ": " + prodotto.toString());
            i++;
        }
    }

    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }
}
