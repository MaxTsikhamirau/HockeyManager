package com.example.demo.tsikhamirau.valueObjects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Statistics implements IPlayerObject {
    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "player")})
    private int playerId;
    private int assists;
    private int goals;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Player player;

    public int getAssists() {
        return assists;
    }

    public Statistics() {
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

    public Statistics(int assists, int goals) {
        this.assists = assists;
        this.goals = goals;
    }
}
