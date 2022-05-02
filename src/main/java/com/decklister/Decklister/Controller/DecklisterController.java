package com.decklister.Decklister.Controller;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Deck;
import com.decklister.Decklister.persistence.repository.DeckRepository;
import com.decklister.Decklister.service.DecklisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/decklister")
public class DecklisterController {
    @Autowired
    private DecklisterService decklisterService;

    @Autowired
    private DeckRepository deckRepository;

    @GetMapping("/decks")
    public Iterable<Deck> findAllDecks() {
        return decklisterService.findAllDecks();
    }

    @PostMapping(value = "/decks")
    public Deck createDeck(@RequestBody Deck newDeck) {
        return decklisterService.createDeck(newDeck);
    }

    @DeleteMapping(value = "/decks/{deckName}")
    public void deleteDeck(@PathVariable String deckName) {
        decklisterService.deleteDeck(deckName);
    }

    @GetMapping("/cards")
    public Iterable<Card> findAllCards() {
        return decklisterService.findAllCards();
    }
}
