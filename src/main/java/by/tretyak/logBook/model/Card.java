package by.tretyak.logBook.model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@NoArgsConstructor
public class Card {

    @Id
    private String id;

    private int cardId;

    private Double balance;

}
