package it.unicam.cs.SmartChaletUnicam.db;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import it.unicam.cs.SmartChaletUnicam.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MongoDB {

    MongoClient mongo;
    MongoDatabase database;

    public MongoDB() {
        this.mongo = new MongoClient( "localhost" , 27017 );
        this.database = this.mongo.getDatabase("SmartChaletUnicam");
    }

    public ArrayList<Attivita> dbGetAllAttivita() {
        ArrayList<Attivita> listaAttivita = new ArrayList<>();
        MongoCollection<Document> collection = this.database.getCollection("attivita");
        for(Document doc : collection.find()) {
            ArrayList<String> listaClienti = new ArrayList<>();
            for(String cliente : (ArrayList<String>)doc.get("listaClienti")) {
                listaClienti.add(cliente);
            }
            Attivita attivita = new Attivita(doc.getObjectId("_id").toString(),
                    doc.getString("nome"),
                    doc.getString("descrizione"),
                    doc.getDate("data"),
                    listaClienti);
            listaAttivita.add(attivita);
        }
        return listaAttivita;
    }

    public void dbSetAttivita(Attivita attivita) {
        MongoCollection<Document> collection = this.database.getCollection("attivita");
        ObjectId id = new ObjectId(attivita.getID());
        collection.updateOne(Filters.eq("_id", id), Updates.set("nome", attivita.getNome()));
        collection.updateOne(Filters.eq("_id", id), Updates.set("descrizione", attivita.getDescrizione()));
        collection.updateOne(Filters.eq("_id", id), Updates.set("data", attivita.getData()));
        collection.updateOne(Filters.eq("_id", id), Updates.set("listaClienti", attivita.getListaClienti()));
        System.out.println("attivita modificata con successo");
    }

    public ArrayList<Ordinazione> dbGetAllOrdinazioni() {
        ArrayList<Ordinazione> listaOrdinazioni = new ArrayList<>();
        MongoCollection<Document> collection = this.database.getCollection("ordinazione");
        for(Document doc : collection.find()) {
            Map<String, Integer> listaProdotti = new HashMap<>();
            Document prodotti = (Document) doc.get("listaProdotti");
            for(Map.Entry<String, Object> prodotto : prodotti.entrySet()) {
                String idProdotto = prodotto.getKey();
                Integer quantita = (Integer) prodotto.getValue();
                listaProdotti.put(idProdotto, quantita);
            }
            Ordinazione ordinazione = new Ordinazione(doc.getObjectId("_id").toString(),
                    doc.getInteger("idOmbrellone"),
                    doc.getDate("data"),
                    listaProdotti,
                    doc.getDouble("prezzoTotale"),
                    doc.getInteger("stato"));
            listaOrdinazioni.add(ordinazione);
        }
        return  listaOrdinazioni;
    }

    public void dbSetOrdinazione(Ordinazione ordinazione) {
        MongoCollection<Document> collection = this.database.getCollection("ordinazione");
        ObjectId id = new ObjectId(ordinazione.getID());
        collection.updateOne(Filters.eq("_id", id), Updates.set("stato", ordinazione.getStato()));
    }

    public String dbAddOrdinazione(Ordinazione ordinazione) {
        MongoCollection<Document> collection = this.database.getCollection("ordinazione");
        Document listaProdotti = new Document();
        for(Map.Entry<String, Integer> prodotto : ordinazione.getListaProdotti().entrySet()) {
            listaProdotti.append(prodotto.getKey(), prodotto.getValue());
        }
        Document document = new Document("idOmbrellone", ordinazione.getIdOmbrellone())
                .append("data", ordinazione.getOrario())
                        .append("listaProdotti", listaProdotti)
                                .append("prezzoTotale", ordinazione.getPrezzoTotale())
                                        .append("stato", ordinazione.getStato());
        collection.insertOne(document);
        return document.getObjectId("_id").toString();
    }

    public Listino dbGetListino() {
        ArrayList<Prodotto> listaProdotti = new ArrayList<>();
        MongoCollection<Document> collection = this.database.getCollection("listino");
        for(Document doc : collection.find()) {
            Prodotto prodotto = new Prodotto(doc.getObjectId("_id").toString(),
                    doc.getString("nome"),
                    doc.getDouble("prezzo"));
            listaProdotti.add(prodotto);
        }
        Listino listino = new Listino(listaProdotti);
        return listino;
    }

    public String dbNuovoCliente(Cliente cliente, String password) {
        MongoCollection<Document> collection = this.database.getCollection("user");
        Document document = new Document("mail", cliente.getMail())
                .append("ruolo", 2)
                        .append("nome", cliente.getNome())
                                .append("cognome", cliente.getCognome())
                                        .append("password", BCrypt.hashpw(password, BCrypt.gensalt()));
        collection.insertOne(document);
        return document.getObjectId("_id").toString();
    }

    public String dbLoginUser(String mail, String password) {
        String id = "";
        MongoCollection<Document> collection = this.database.getCollection("user");
        for(Document doc : collection.find(Filters.eq("mail", mail))) {
            if(BCrypt.checkpw(password, doc.getString("password"))) {
                id = doc.getObjectId("_id").toString();
            }
        }
        return id;
    }

    public boolean dbAlreadyExist(String mail) {
        MongoCollection<Document> collection = this.database.getCollection("user");
        if(collection.countDocuments(Filters.eq("mail", mail)) == 0)
            return false;
        else return true;
    }

    /*
    public void dbAggiungiClienteAttivita(Attivita attivita, String idCliente) {
        MongoCollection<Document> collection = this.database.getCollection("attivita");
        ObjectId id = new ObjectId(attivita.getID());
        collection.updateOne(Filters.eq("_id", id), Updates.push("listaClienti", attivita.getListaClienti().get(attivita.getListaClienti().size() - 1)));
    }
     */

}
