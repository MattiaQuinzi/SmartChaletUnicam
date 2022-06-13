package it.unicam.cs.SmartChaletUnicam.Controller;
import it.unicam.cs.SmartChaletUnicam.Cliente;
import it.unicam.cs.SmartChaletUnicam.db.MongoDB;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private String idUtente;
    private MongoDB mongo;
    private BCrypt bCrypt;

    public UserController(){
        this.idUtente = "";
        this.mongo = new MongoDB();
        this.bCrypt = new BCrypt();
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }

    public void nuovoCliente() {
        String nome, cognome, mail, password;
        boolean alreadyExist = false;
        Scanner reader = new Scanner(System.in);
        System.out.print("nome: ");
        nome = reader.nextLine();
        System.out.print("cognome: ");
        cognome = reader.nextLine();
        do {
            mail = this.checkMail();
            alreadyExist = this.mongo.dbAlreadyExist(mail);
            if(alreadyExist)
                System.out.println("Esiste già un utente con questa mail");
        }while(alreadyExist);
        password = this.checkPassword();
        Cliente nuovoCliente = new Cliente("", mail, nome, cognome);
        this.idUtente = this.mongo.dbNuovoCliente(nuovoCliente, password);
        nuovoCliente.setID(this.idUtente);
        System.out.println("aggiunto nuovo cliente");
    }

    private String checkMail(){
        String mail;
        Scanner reader = new Scanner(System.in);
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        do {
            System.out.print("mail: ");
            mail = reader.nextLine();
            matcher = pattern.matcher(mail);
            if(!matcher.matches()) {
                System.out.println("Mail non valida");
            }
        } while(!matcher.matches());
        return mail;
    }

    private String checkPassword() {
        String password;
        Scanner reader = new Scanner(System.in);
        do {
            System.out.print("password (min 8, max 16): ");
            password = reader.nextLine();
            if(password.length() < 8 || password.length() > 16)
                System.out.println("password non valida");
        }while (password.length() < 8 || password.length() > 16);
        return password;
    }

    public boolean loginUtente(){
        String mail, password;
        Scanner reader = new Scanner(System.in);
        System.out.print("mail: ");
        mail = reader.nextLine();
        System.out.print("password: ");
        password = reader.next();
        String idUser = this.mongo.dbLoginUser(mail, password);
        if(idUser.equals("")) {
            System.out.println("Credenziali non valide");
            return false;
        }
        else {
            this.idUtente = idUser;
            System.out.println("Accesso con id " + idUser);
            return true;
        }
    }
}
