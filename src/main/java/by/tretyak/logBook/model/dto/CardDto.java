package by.tretyak.logBook.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CardDto {

    private Integer id;

    private Double balance;

    public CardDto(Integer id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

}
