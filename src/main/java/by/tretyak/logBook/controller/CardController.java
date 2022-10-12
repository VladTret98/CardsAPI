package by.tretyak.logBook.controller;

import by.tretyak.logBook.model.dto.CardDto;
import by.tretyak.logBook.model.dto.CardsDto;
import by.tretyak.logBook.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/balance")
    public CardDto getCardBalance(@RequestBody CardDto card) {
        return this.cardService.getCardBalance(card);
    }

    @GetMapping("/cards")
    public CardsDto findAll() {
        return this.cardService.findAll();
    }

    @PostMapping("/cards")
    public CardsDto getUserCardsInfo(@RequestBody List<Integer> cardsId) {
        return this.cardService.getUserCards(cardsId);
    }

    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }
}
