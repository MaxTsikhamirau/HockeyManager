package com.example.demo;

import com.example.demo.tsikhamirau.repository.PlayerRepository;
import com.example.demo.tsikhamirau.valueObjects.Player;
import com.example.demo.tsikhamirau.valueObjects.Skill;
import com.example.demo.tsikhamirau.valueObjects.Statistics;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);

      }


}
