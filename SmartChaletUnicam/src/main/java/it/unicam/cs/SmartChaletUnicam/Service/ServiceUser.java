package it.unicam.cs.SmartChaletUnicam.Service;

import it.unicam.cs.SmartChaletUnicam.Model.Notifica;
import it.unicam.cs.SmartChaletUnicam.Model.User;
import it.unicam.cs.SmartChaletUnicam.Repository.RepositoryNotifica;
import it.unicam.cs.SmartChaletUnicam.Repository.RepositoryUser;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser repositoryUser;

    public List<User> getUsers(){
        return repositoryUser.findAll();
    }

    public User getUserByMail(User user) {
        User utente = repositoryUser.findByMail(user.getMail());
        if(utente != null) {
            return utente;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "utente non trovato");
        }
    }

    public User login(User user) {
        User utente = repositoryUser.findByMail(user.getMail());
        if(utente != null) {
            if(BCrypt.checkpw(user.getPassword(), utente.getPassword())) {
                return utente;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "credenziali non valide");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "credenziali non valide");
        }
    }

    public User createUser(User user) {
        User utente = repositoryUser.findByMail(user.getMail());
        if(utente != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "utente già esistente");
        } else {
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            return repositoryUser.insert(user);
        }
    }

}
