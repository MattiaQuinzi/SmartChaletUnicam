package it.unicam.cs.SmartChaletUnicam;

public class User {
    private String ID;
    private String mail;

    public User(String ID, String mail) {
        this.ID=ID;
        this.mail = mail;
    }

    public String getID() { return ID; }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}