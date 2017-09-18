package com.example.demo.tsikhamirau.Repository;

import com.example.demo.tsikhamirau.valueObjects.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
