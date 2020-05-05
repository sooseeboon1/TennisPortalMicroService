package com.tennisportal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tennisportal.model.Player;
import com.tennisportal.model.Players;
import com.tennisportal.repo.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository playerRepository;
	
	public Players getPlayers() {		
		
		Players players = new Players();
		playerRepository.findAll().forEach( player -> { 
			players.getPlayers().add(player);
			
		});
		return players;
	}
	
	public void savePlayer(Player player) {
		playerRepository.save(player);
	}

	public Optional<Player> getPlayer(Long playerId) {
		return playerRepository.findById(playerId);
	}
}
