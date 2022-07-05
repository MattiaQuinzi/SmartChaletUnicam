package it.unicam.cs.SmartChaletUnicam.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "attivita")
public class Attivita {

    @Id
    private String id;
    private String nome;
    private String descrizione;
    private Date data;
    private ArrayList<String> listaClienti;
    private int maxPartecipanti;

}
