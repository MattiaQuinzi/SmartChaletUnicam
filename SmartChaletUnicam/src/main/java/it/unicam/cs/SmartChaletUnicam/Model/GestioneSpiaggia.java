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
@Document(collection = "gestioneSpiaggia")
public class GestioneSpiaggia {

    @Id
    private String id;
    private double prezzoOmbrellone;
    private double prezzoLettino;
    private double prezzoSdraio;

}
