package com.tennisportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tennisportal.model.Player;
import com.tennisportal.model.Players;

@Service
public class PlayerService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${player.service.url}")
	String playerServiceUrl;
	
	// threadPoolKey is used for bulkhead design pattern.
	@HystrixCommand(fallbackMethod = "getPlayersFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") }, threadPoolKey = "getPlayerThreadPool")
	public ResponseEntity<Players> getPlayers() {
		String url =  playerServiceUrl + "/tennisportal/players/";
		System.out.println("Player service URL is "  + url);
		ResponseEntity<Players> responseEntity = restTemplate.getForEntity(url, Players.class);
		return responseEntity;
	}
	
	public ResponseEntity<Players> getPlayersFallBack() {		
		Player player = new Player();
		player.setName("Mr.NoName");
		player.setId(new Long(1));
		Players players = new Players();
		players.getPlayers().add(player);
		return ResponseEntity.ok(players);
		
	}
	
	// threadPoolKey is used for bulkhead design pattern.
	@HystrixCommand(fallbackMethod = "getPlayerFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") }, threadPoolKey = "getPlayerThreadPool")
	public ResponseEntity<Player> getPlayer(@PathVariable Long playerId) {		
		 ResponseEntity<Player> responseEntity = restTemplate.getForEntity(playerServiceUrl + "/tennisportal/players/" + playerId, Player.class);
		 return responseEntity;
	}
	
	public ResponseEntity<Player> getPlayerFallBack(Long playerId)  {		
		Player player = new Player();
		player.setName("Mr.NoName");
		player.setId(new Long(1));
		return ResponseEntity.ok(player);
		
	}
		
	// threadPoolKey is used for bulkhead design pattern.
	@HystrixCommand(fallbackMethod = "savePlayerFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") }, threadPoolKey = "savePlayerThreadPool")
	public ResponseEntity<Player> savePlayer(@RequestBody Player player) {		
		ResponseEntity<Player> responseEntity = restTemplate.postForEntity(playerServiceUrl + "/tennisportal/players/", player, Player.class);
		return responseEntity;
	}
		
	public ResponseEntity<Player> savePlayerFallBack(@RequestBody Player player) throws Exception {
		throw new Exception("Failed to save");
	}
}
