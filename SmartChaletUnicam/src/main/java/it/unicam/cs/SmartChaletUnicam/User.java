package it.unicam.cs.SmartChaletUnicam;

public class User {
    private String mail, name, surname;

    public User(String mail, String name, String surname) {
        this.mail = mail;
        this.name = name;
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}