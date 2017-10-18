package com.example.demo.tsikhamirau.controllers;


import com.example.demo.tsikhamirau.exceptions.UserNotFoundException;
import com.example.demo.tsikhamirau.repository.PlayerRepository;
import com.example.demo.tsikhamirau.service.IPlayerDAOService;
import com.example.demo.tsikhamirau.valueObjects.IPlayerObject;
import com.example.demo.tsikhamirau.valueObjects.Player;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "View a list of all players", response = ResponseEntity.class)
    public ResponseEntity<List<Player>> getPlayers() {
        System.out.println("playerDAOService = " + playerRepository.findAll());
        return new ResponseEntity<List<Player>>((List<Player>) playerRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create a new player", response = ResponseEntity.class)
    public ResponseEntity<?> createPlayer(@RequestBody Player player) {
        IPlayerObject newPlayer = playerRepository.save(player);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/players")
                .buildAndExpand(newPlayer.getPlayerId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/{player_id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a player by ID", response = ResponseEntity.class)
    public ResponseEntity<?> deletePlayer(@PathVariable String player_id) {
        ifUserExists(player_id);
        playerRepository.delete(Integer.valueOf(player_id));
        return new ResponseEntity(HttpStatus.OK);
    }

    private void ifUserExists(String player_id) {
        if (!playerRepository.exists(Integer.valueOf(player_id))) {
            throw new UserNotFoundException("Player {} doesn't exist", player_id);
        }
    }

    @RequestMapping(value = "/{player_id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get player by ID", response = ResponseEntity.class)
    public ResponseEntity<?> getPlayer(@PathVariable String player_id) {
        return new ResponseEntity<>(playerRepository.findOne(Integer.valueOf(player_id)), HttpStatus.OK);
    }
}
