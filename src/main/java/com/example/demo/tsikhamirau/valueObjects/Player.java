package com.example.demo.tsikhamirau.valueObjects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "player")
public class Player implements IPlayerObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer playerId;
    @Size(min =2 , message = "Name should have at least 2 characters ")
    private String name;
    @Size(min =2)
    private String country;
    private int age;
    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Skill skill;
    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Statistics statistics;

    public Integer getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Skill getSkill() {
        return skill;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Statistics getStatistics() {
        return statistics;
    }

    public Player(String name, String country, int age, Skill skill, Statistics statistics) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.skill = skill;
        this.statistics = statistics;
    }

    public Player() {
    }

    public static class Builder {
        private String name;
        private String country;
        private int age;
        private Skill skill;
        private Statistics statistics;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setSkill(Skill skill) {
            this.skill = skill;
            return this;
        }

        public Builder setStatistics(Statistics statistics) {
            this.statistics = statistics;
            return this;
        }

        public Player build() {
            return new Player(name, country, age, skill, statistics);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", skill=" + skill +
                ", statistics=" + statistics +
                '}';
    }
}
