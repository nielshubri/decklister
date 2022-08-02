package com.decklister.Decklister.Controller;

import com.decklister.Decklister.persistence.model.Player;
import com.decklister.Decklister.persistence.model.User;
import com.decklister.Decklister.service.DecklisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/mvc")
public class MVCController {

    @Autowired
    private DecklisterService decklisterService;

    @GetMapping(value = "/users")
    public String getUsers(Model model) {
        Iterable<User> users = decklisterService.findAllUsers();
        List<User> userList = new ArrayList<>();
        users.forEach(u -> userList.add(u));

        model.addAttribute("users", userList);

        return "users";
    }

    @GetMapping(value = "/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @PostMapping(value = "/newUser")
    public String addUser(User user) {
        decklisterService.createUser(user);
        return "redirect:/mvc/users";
    }

    @GetMapping(value = "/players")
    public String getPlayers(Model model) {
        Iterable<Player> players = decklisterService.findAllPlayers();
        List<Player> playerList = new ArrayList<>();
        players.forEach(p -> playerList.add(p));

        model.addAttribute("players", playerList);

        return "players";
    }

    @GetMapping(value = "/newPlayer")
    public String newPlayer(Model model) {
        model.addAttribute("player", new Player());
        return "new-player";
    }

    @PostMapping(value = "/newPlayer")
    public String addPlayer(Player player) {
        decklisterService.createPlayer(player);
        return "redirect:/mvc/players";
    }
}
