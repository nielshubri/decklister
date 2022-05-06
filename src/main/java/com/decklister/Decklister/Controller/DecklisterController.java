package com.decklister.Decklister.Controller;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Deck;
import com.decklister.Decklister.persistence.model.User;
import com.decklister.Decklister.persistence.repository.CardRepository;
import com.decklister.Decklister.persistence.repository.DeckRepository;
import com.decklister.Decklister.persistence.repository.UserRepository;
import com.decklister.Decklister.service.DecklisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/decklister")
public class DecklisterController {
    @Autowired
    private DecklisterService decklisterService;

    @Secured("ROLE_JUDGE")
    @GetMapping("/decks")
    public Iterable<Deck> findAllDecks() {
        return decklisterService.findAllDecks();
    }

    @Secured({"ROLE_PARTICIPANT","ROLE_JUDGE"})
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

    @GetMapping("/users")
    public Iterable<User> findAllUsers() {return decklisterService.findAllUsers();}

    @PostMapping("/users")
    public User createUser(@RequestBody User newUser) {
        return decklisterService.createUser(newUser);
    }
}
