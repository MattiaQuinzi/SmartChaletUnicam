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
@Document(collection = "ombrellone")
public class Ombrellone {

    @Id
    private String id;
    private int idOmbrellone;
    private int numLettini;
    private int numSdraio;
    private String stato;

}
