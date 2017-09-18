package com.example.demo.tsikhamirau.controllers;


import com.example.demo.tsikhamirau.Repository.PlayerRepository;
import com.example.demo.tsikhamirau.service.IPlayerDAOService;
import com.example.demo.tsikhamirau.valueObjects.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players/")
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
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        // System.out.println("playerDAOService = " + playerDAOService.getAll());
        return new ResponseEntity<Player>(playerDAOService.create(player), HttpStatus.CREATED);
    }

}
