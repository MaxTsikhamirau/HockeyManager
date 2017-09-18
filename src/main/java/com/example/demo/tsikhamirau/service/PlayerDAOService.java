package com.example.demo.tsikhamirau.service;

import com.example.demo.tsikhamirau.valueObjects.Player;
import com.example.demo.tsikhamirau.valueObjects.Skill;
import com.example.demo.tsikhamirau.valueObjects.Statistics;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerDAOService implements IPlayerDAOService {
    private static List<Player> players;

    static {
        players = new ArrayList<Player>();
        players.add(new Player.Builder().setAge(28)
                .setCountry("Belarus")
                .setName("Maksim Tsikhamirau")
                .setSkill(new Skill(100, 100, 100))
                .setStatistics(new Statistics(20, 20)).build());

    }

    @Override
    public List<Player> getAll() {
        return players;
    }

    @Override
    public Player getById(int id) {
        return players.get(id);
    }

    @Override
    public int delete(int id) {
        players.remove(id);
        return id;
    }

    @Override
    public Player create(Player player) {
        players.add(player);

        return player;
    }

    @Override
    public Player update(int id) {
        return null;
    }

}
