package com.example.demo.tsikhamirau.valueObjects;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player implements IPlayerObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerId;
    private String name;
    private String country;
    private int age;
    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private Skill skill;
    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private Statistics statistics;

    public int getPlayerId() {
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
