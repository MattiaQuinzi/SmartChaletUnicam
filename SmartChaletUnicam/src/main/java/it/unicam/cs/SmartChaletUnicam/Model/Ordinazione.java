package it.unicam.cs.SmartChaletUnicam.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "ordinazione")
public class Ordinazione {

    @Id
    private String id;
    private int idOmbrellone;
    private Date data;
    private Map<String, Integer> listaProdotti;
    private double prezzoTotale;
    private int stato;

}
