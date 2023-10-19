package com.fita.game.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fita.game.model.Game;
import com.fita.game.service.GameService;

@RestController
@RequestMapping("/game")
public class GameRestController {

	@Autowired
	private GameService gameService; 
	
	@GetMapping
	@ResponseBody
	public List<Game> listar() {
		return gameService.listar();
	}
	
	@PostMapping
	public String cadastrar(@RequestBody Game game) {
		return gameService.salvar(game);
	}
	
	@PutMapping("{id}")
	public String alterar(@RequestBody Game game, @PathVariable("id") long id) {
		Optional<Game> gameEncontrado = gameService.getById(id);
		if (gameEncontrado.isPresent()) {
			return gameService.salvar(game);
		} else {
			return "Game não encontrado!";
		}
	}
	
	@DeleteMapping("{id}")
	public String deletar(@PathVariable("id") long id) {
		Optional<Game> gameEncontrado = gameService.getById(id);
		if (gameEncontrado.isPresent()) {
			return gameService.deletar(id);
		} else {
			return "Game não encontrado!";
		}
	}	
}
