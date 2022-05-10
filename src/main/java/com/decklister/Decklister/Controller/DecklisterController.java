package com.decklister.Decklister.Controller;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Deck;
import com.decklister.Decklister.persistence.model.Participant;
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
public class DecklisterController {
    @Autowired
    private DecklisterService decklisterService;

    @GetMapping("/judge/decks")
    public Iterable<Deck> findAllDecks() {
        return decklisterService.findAllDecks();
    }

    @GetMapping("/judge/cards")
    public Iterable<Card> findAllCards() {
        return decklisterService.findAllCards();
    }

    @GetMapping("/judge/participants")
    public Iterable<Participant> findAllParticipants() {
        return decklisterService.findAllParticipants();
    }

    @PostMapping(value = "/participant/decks")
    public Deck createDeck(@RequestBody Deck newDeck) {
        return decklisterService.createDeck(newDeck);
    }

    @PostMapping(value = "/participant/create")
    public Participant createParticipant(@RequestBody Participant newParticipant) {
        return decklisterService.createParticipant(newParticipant);
    }

    @DeleteMapping(value = "/participant/decks/{deckName}")
    public void deleteDeck(@PathVariable String deckName) {
        decklisterService.deleteDeck(deckName);
    }

    @GetMapping("/users")
    public Iterable<User> findAllUsers() {return decklisterService.findAllUsers();}

    @PostMapping("/users")
    public User createUser(@RequestBody User newUser) {
        return decklisterService.createUser(newUser);
    }
}