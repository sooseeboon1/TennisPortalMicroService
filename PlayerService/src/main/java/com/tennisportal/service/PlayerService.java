package com.tennisportal.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tennisportal.model.Player;
import com.tennisportal.model.Players;
import com.tennisportal.repo.PlayerRepository;

@Service
public class PlayerService {
	
	Logger logger = LoggerFactory.getLogger(PlayerService.class);
	
	
	@Autowired
	private PlayerRepository playerRepository;
		
	public Players getPlayers() {		
		Players players = new Players();
		players.getPlayers().clear();
		playerRepository.findAll().forEach( player -> { 
			players.getPlayers().add(player);
			
		});
		logger.debug("Players return from database");
		players.getPlayers().forEach(player -> { 
					logger.debug("Player name: " + player.getName());
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
