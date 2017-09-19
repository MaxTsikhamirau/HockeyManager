package com.example.demo.tsikhamirau.controllers;


import com.example.demo.tsikhamirau.repository.PlayerRepository;
import com.example.demo.tsikhamirau.service.IPlayerDAOService;
import com.example.demo.tsikhamirau.valueObjects.Player;
import com.example.demo.tsikhamirau.valueObjects.Skill;
import com.example.demo.tsikhamirau.valueObjects.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
//        new Player.Builder().setAge(10)
//                .setCountry("Belarus")
//                .setName("Daniil Tsikhamirau")
//                .setSkill(new Skill(100, 100, 100))
//                .setStatistics(new Statistics(20, 20)).build();
        Player newPlayer = playerRepository.save(player);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/players")
                .buildAndExpand(newPlayer.getPlayerId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
