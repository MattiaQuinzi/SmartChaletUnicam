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
@Document(collection = "prenotazione")
public class Prenotazione {

    @Id
    private String id;
    private String idCliente;
    private Date dataInizio;
    private Date dataFine;
    private ArrayList<Integer> listaOmbrelloni;

}
