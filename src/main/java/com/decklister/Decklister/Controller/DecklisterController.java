package com.decklister.Decklister.Controller;

import com.decklister.Decklister.persistence.model.Card;
import com.decklister.Decklister.persistence.model.Deck;
import com.decklister.Decklister.persistence.model.Player;
import com.decklister.Decklister.persistence.model.User;
import com.decklister.Decklister.service.DecklisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DecklisterController {
    @Autowired
    private DecklisterService decklisterService;

    @GetMapping("/judge/decks")
    public Iterable<Deck> findAllDecks() {
        return decklisterService.findAllDecks();
    }

    @PostMapping(value = "/player/decks")
    public Deck createDeck(@RequestBody Deck newDeck) {
        return decklisterService.createDeck(newDeck);
    }

    @DeleteMapping(value = "/player/decks/{deckName}")
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