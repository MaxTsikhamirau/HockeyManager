package com.example.demo.tsikhamirau.controllers;

import com.example.demo.tsikhamirau.service.IPlayerDAOService;
import com.example.demo.tsikhamirau.valueObjects.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams/")
public class TeamController {
    // TODO: 9/8/2017  
    @Autowired
    IPlayerDAOService playerDAOService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getPlayers() {
        System.out.println("playerDAOService = " + playerDAOService.getAll());
        return new ResponseEntity<List<Player>>(playerDAOService.getAll(), HttpStatus.OK);
    }

}
