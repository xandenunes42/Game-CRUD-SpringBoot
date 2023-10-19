package com.fita.game.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.game.model.Game;
import com.fita.game.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;

	public List<Game> listar() {
		return gameRepository.findAll();
	}
	
	public String salvar(Game game) {
		gameRepository.save(game);
		return "Game gravado!";
	}

	public String deletar(long id) {
		gameRepository.deleteById(id);
		return "Game excluído!";
	}
	
	public Optional<Game> getById(long id) {
		return gameRepository.findById(id);
	}
}
