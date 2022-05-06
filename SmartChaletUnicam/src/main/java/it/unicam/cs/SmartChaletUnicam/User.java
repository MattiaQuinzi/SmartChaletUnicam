package it.unicam.cs.SmartChaletUnicam;

public class User {
    private int ID;
    private String mail;

    public User( int ID, String mail) {
        this.ID=ID;
        this.mail = mail;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}