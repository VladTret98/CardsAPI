package by.tretyak.logBook.repository;

import by.tretyak.logBook.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CardRepository extends MongoRepository<Card, String>{

    Optional<Card> findByCardId(int cardId);

}
