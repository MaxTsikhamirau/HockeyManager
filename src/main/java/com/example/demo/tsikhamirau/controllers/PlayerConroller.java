package com.example.demo.tsikhamirau.controllers;


import com.example.demo.tsikhamirau.exceptions.UserNotFoundException;
import com.example.demo.tsikhamirau.repository.PlayerRepository;
import com.example.demo.tsikhamirau.service.IPlayerDAOService;
import com.example.demo.tsikhamirau.valueObjects.IPlayerObject;
import com.example.demo.tsikhamirau.valueObjects.Player;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerConroller {

    @Autowired
    IPlayerDAOService playerDAOService;

    @Autowired
    PlayerRepository playerRepository;


    @GetMapping
    @ApiOperation(value = "View a list of all players", response = ResponseEntity.class)
    public ResponseEntity<List<Player>> getPlayers() {
        System.out.println("playerDAOService = " + playerRepository.findAll());
        return new ResponseEntity<List<Player>>((List<Player>) playerRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new player", response = ResponseEntity.class)
    public ResponseEntity<?> createPlayer(@Valid @RequestBody Player player) {
        IPlayerObject newPlayer = playerRepository.save(player);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/players")
                .buildAndExpand(newPlayer.getPlayerId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{player_id}")
    @ApiOperation(value = "Delete a player by ID", response = ResponseEntity.class)
    public ResponseEntity<?> deletePlayer(@PathVariable String player_id) {
        ifUserExists(player_id);
        playerRepository.delete(Integer.valueOf(player_id));
        return new ResponseEntity(HttpStatus.OK);
    }

    private boolean ifUserExists(String player_id) {
        return playerRepository.exists(Integer.valueOf(player_id));
    }

    @GetMapping(value = "/{player_id}")
    @ApiOperation(value = "Get player by ID", response = ResponseEntity.class)
    public Resource<Player> getPlayer(@PathVariable String player_id) {
      if (!ifUserExists(player_id)) {
        throw new UserNotFoundException("No such player found: " + player_id);
      }
        Player player = playerRepository.findOne(Integer.valueOf(player_id));
        Resource<Player> resource = new Resource<>(player);
        final ControllerLinkBuilder linkTo = ControllerLinkBuilder
            .linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getPlayers());
        resource.add(linkTo.withSelfRel());
        return resource;
    }
}
