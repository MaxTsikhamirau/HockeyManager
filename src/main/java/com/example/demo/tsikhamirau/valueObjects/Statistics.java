package com.example.demo.tsikhamirau.valueObjects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "statistics")
public class Statistics implements Serializable {

    private int assists;
    private int goals;
    private Player player;

    public Statistics() {
    }

    public Statistics(int assists, int goals) {
        this.assists = assists;
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    @Id
    @OneToOne
    @JoinColumn(name = "player_id")
    @JsonBackReference
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "assists=" + assists +
                ", goals=" + goals +
                ", player=" + player +
                '}';
    }
}
