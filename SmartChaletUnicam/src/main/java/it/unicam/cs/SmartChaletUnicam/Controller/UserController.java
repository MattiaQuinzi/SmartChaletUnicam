package it.unicam.cs.SmartChaletUnicam.Controller;
import it.unicam.cs.SmartChaletUnicam.Cliente;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {


    private static int ID = 0;
    public ArrayList<Cliente> listaClienti ;

    public UserController(){
        listaClienti = new ArrayList<>();
        //chiamata backend per prendere tutti i clienti
        //chiamata backend per l'ID
    }

    public void nuovoCliente() {
        String nome, cognome, mail;
        Scanner reader = new Scanner(System.in);
        System.out.println("nome");
        nome = reader.next();
        System.out.println("cognome");
        cognome = reader.next();
        System.out.println("mail");
        mail = this.checkMail();

        Cliente nuovoCliente = new Cliente(ID, mail, nome, cognome);
        listaClienti.add(nuovoCliente);
        ID++;
    }

    private String checkMail(){
        String mail;
        Scanner reader = new Scanner(System.in);
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        do {
            mail = reader.next();
            matcher = pattern.matcher(mail);
        } while(!matcher.matches());

        return mail;
    }

    public boolean loginUtente(){
        String mail, password;
        Scanner reader = new Scanner(System.in);
        System.out.println("mail");
        mail = reader.next();
        System.out.println("password");
        password = reader.next();

        if(userExsist(mail, password)){
            return true;
        }
        return false;
    }

    private boolean userExsist(String mail, String password) {
        //controllo esistenza dati nel database
        return true; // se esiste altrimenti return false
    }
}
