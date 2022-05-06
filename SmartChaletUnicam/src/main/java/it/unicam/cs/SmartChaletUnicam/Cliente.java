package it.unicam.cs.SmartChaletUnicam;

public class Cliente extends User{

    private final String nome, cognome;

    public Cliente(int ID, String mail, String nome, String cognome) {
        super(ID, mail);
        this.nome=nome;
        this.cognome=cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}