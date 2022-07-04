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
@Document(collection = "listino")
public class Prodotto {

    @Id
    private String id;
    private String nome;
    private double prezzo;

}
