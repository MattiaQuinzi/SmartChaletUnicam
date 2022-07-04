package it.unicam.cs.SmartChaletUnicam.Repository;

import it.unicam.cs.SmartChaletUnicam.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends MongoRepository<User, String> {

    public User findByMail(String mail);

}
