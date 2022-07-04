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
@Document(collection = "notifica")
public class Notifica {

    @Id
    private String id;
    private String titolo;
    private String messaggio;

}
