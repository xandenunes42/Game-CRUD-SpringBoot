package com.fita.game.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fita.game.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
	public List<Game> findAll();
}
