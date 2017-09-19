package com.example.demo.tsikhamirau.controllers;


import com.example.demo.tsikhamirau.exceptions.UserNotFoundException;
import com.example.demo.tsikhamirau.repository.PlayerRepository;
import com.example.demo.tsikhamirau.service.IPlayerDAOService;
import com.example.demo.tsikhamirau.valueObjects.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerConroller {

    @Autowired
    IPlayerDAOService playerDAOService;

    @Autowired
    PlayerRepository playerRepository;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getPlayers() {
        System.out.println("playerDAOService = " + playerRepository.findAll());
        return new ResponseEntity<List<Player>>((List<Player>) playerRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createPlayer(@RequestBody Player player) {
        Player newPlayer = playerRepository.save(player);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/players")
                .buildAndExpand(newPlayer.getPlayerId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/{player_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePlayer(@PathVariable String player_id) {
        ifUserExists(player_id);
        playerRepository.delete(Integer.valueOf(player_id));
        return new ResponseEntity(HttpStatus.OK);
    }

    private void ifUserExists(String player_id) {
        if (playerRepository.findOne(Integer.valueOf(player_id)) == null) {
            throw new UserNotFoundException("Player {} doesn't exist", player_id);
        }
    }

    @RequestMapping(value = "/{player_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPlayer(@PathVariable String player_id) {
        return new ResponseEntity<>(playerRepository.findOne(Integer.valueOf(player_id)), HttpStatus.OK);
    }
}
