package by.tretyak.logBook.controller;

import by.tretyak.logBook.exception.ObjectNotFoundException;
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

    private static final String BALANCE_PATH = "/balance";
    private static final String CARDS_PATH = "/cards";

    @PostMapping(BALANCE_PATH)
    public CardDto getCardBalance(@RequestBody CardDto card) throws ObjectNotFoundException {
        return this.cardService.getCardBalance(card);
    }

    @GetMapping(CARDS_PATH)
    public CardsDto findAll() throws ObjectNotFoundException  {
        return this.cardService.findAll();
    }

    @PostMapping(CARDS_PATH)
    public CardsDto getUserCardsInfo(@RequestBody List<Integer> cardsId) throws ObjectNotFoundException  {
        return this.cardService.getUserCards(cardsId);
    }

    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }
}
