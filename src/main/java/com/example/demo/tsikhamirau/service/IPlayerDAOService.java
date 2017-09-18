package com.example.demo.tsikhamirau.service;

import com.example.demo.tsikhamirau.valueObjects.Player;

import java.util.List;

public interface IPlayerDAOService {

    public  List <Player>getAll();

    public Player getById(int id);

    public int delete(int id);

    public Player update(int id);

    public Player create (Player player);
}
