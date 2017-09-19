package com.example.demo.tsikhamirau.valueObjects;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill implements IPlayerObject {

    private Player player;
    private int speed;
    private int passAccuracy;
    private int intelligence;

    public Skill() {
    }

    public Skill(int speed, int passAccuracy, int intelligence) {
        this.speed = speed;
        this.passAccuracy = passAccuracy;
        this.intelligence = intelligence;
    }

    @Id
    @OneToOne
    @JoinColumn(name = "player_id")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPassAccuracy() {
        return passAccuracy;
    }

    public void setPassAccuracy(int passAccuracy) {
        this.passAccuracy = passAccuracy;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "speed=" + speed +
                ", passAccuracy=" + passAccuracy +
                ", intelligence=" + intelligence +
                '}';
    }
}
