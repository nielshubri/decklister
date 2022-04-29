package com.decklister.Decklister.service;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Deck;
import com.decklister.Decklister.persistence.repository.CardRepository;
import com.decklister.Decklister.persistence.repository.DeckRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@NoArgsConstructor
public class DecklisterService {
    @Autowired
    private DeckRepository deckRepository;
    @Autowired
    private CardRepository cardRepository;

    public Iterable<Deck> findAllDecks() {
        return deckRepository.findAll();
    }

    public Deck createDeck (Deck newDeck) {
        return deckRepository.save(newDeck);
    }

    public Iterable<Card> findAllCards() {
        return cardRepository.findAll();
    }

    public void deleteDeck (String deckName) {
        Deck deckToDelete = deckRepository.findByNameEquals(deckName);
        deckRepository.delete(deckToDelete);
    }
}
