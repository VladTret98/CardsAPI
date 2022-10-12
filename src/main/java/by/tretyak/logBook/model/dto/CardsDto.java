package by.tretyak.logBook.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class CardsDto {

    public CardsDto(List<CardDto> cards) {
        this.cards = cards;
    }

    private List<CardDto> cards;

}
