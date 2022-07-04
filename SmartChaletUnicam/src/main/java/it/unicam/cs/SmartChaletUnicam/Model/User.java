package it.unicam.cs.SmartChaletUnicam.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private int ruolo;
    private String mail;
    private String password;
    private String nome;
    private String cognome;

}