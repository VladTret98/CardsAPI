package by.tretyak.logBook.service;

import by.tretyak.logBook.exception.ObjectNotFoundException;
import by.tretyak.logBook.exception.source.ExceptionMessageSource;
import by.tretyak.logBook.model.Card;
import by.tretyak.logBook.model.dto.CardDto;
import by.tretyak.logBook.model.dto.CardsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.tretyak.logBook.repository.CardRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public CardService(CardRepository repository) {
        this.cardRepository = repository;
    }

    public CardsDto findAll() throws ObjectNotFoundException {
        List<Card> cards = this.cardRepository.findAll();
        CardsDto cardsDto = new CardsDto();
        cardsDto.setCards(new ArrayList<>());
        cards.stream().forEach(card ->
                cardsDto.getCards().add(new CardDto(card.getCardId(), card.getBalance())));
        if (cardsDto.getCards().isEmpty()) {
            throw new ObjectNotFoundException(ExceptionMessageSource
            .getMessage(ExceptionMessageSource.DATA_NOT_FOUND));
        }
        return cardsDto;
    }


    public CardDto getCardBalance(CardDto cardDto) throws ObjectNotFoundException {
        Card card = this.cardRepository.findByCardId(cardDto.getId()).orElseThrow(() ->
                new ObjectNotFoundException(ExceptionMessageSource
                        .getMessage(ExceptionMessageSource.DATA_NOT_FOUND)));
        return new CardDto(card.getCardId(), card.getBalance());
    }

    @Transactional
    public CardsDto getUserCards(List<Integer> cardsId) throws ObjectNotFoundException{
        List<CardDto> resultCards = new ArrayList<>();
        for (Integer cardId: cardsId) {
            this.cardRepository.findByCardId(cardId).ifPresent(card ->
                    resultCards.add(new CardDto(card.getCardId(), card.getBalance())));
        }
        if(resultCards.isEmpty()) {
            throw new ObjectNotFoundException(ExceptionMessageSource
            .getMessage(ExceptionMessageSource.DATA_NOT_FOUND));
        }
        return new CardsDto(resultCards);
    }



    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

}
