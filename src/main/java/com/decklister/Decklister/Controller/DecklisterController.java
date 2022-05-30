package com.decklister.Decklister.Controller;

import com.decklister.Decklister.persistence.model.Player;
import com.decklister.Decklister.persistence.model.User;
import com.decklister.Decklister.service.DecklisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class DecklisterController {
    @Autowired
    private DecklisterService decklisterService;

    @GetMapping("/judge/players")
    public Iterable<Player> findAllPlayers() {
        return decklisterService.findAllPlayers();
    }

    @PostMapping(value = "/player/register")
    public Player registerPlayer(@RequestBody Player newPlayer) {
        return decklisterService.createPlayer(newPlayer);
    }

    @DeleteMapping(value = "/player/delete/{playerName}")
    public void deletePlayer(@PathVariable String playerName) {
        decklisterService.deletePlayer(playerName);
    }

    @GetMapping("/users")
    public Iterable<User> findAllUsers() {return decklisterService.findAllUsers();}

    @PostMapping("/users")
    public User createUser(@RequestBody User newUser) {
        return decklisterService.createUser(newUser);
    }

    @DeleteMapping(value = "/users/delete/{userEmail}")
    public void deleteUser(@PathVariable String userEmail) {
        decklisterService.deletePlayer(userEmail);
    }
}