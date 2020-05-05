package com.tennisportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tennisportal.model.Player;
import com.tennisportal.model.Players;
import com.tennisportal.service.PlayerService;


/**  
 *   Location to run: C:\Users\ssoo\Documents\workspace-spring-tool-suite-4-4.5.1.RELEASE\TennisPortal
 *   docker build -t sooseeboon/tennisportal
 *   docker push sooseeboon/tennisportal
 *   docker desktop is running
 *   Example of other docker file: docker_jar under project here.
 *   Git hub: https://github.com/sooseeboon1/tennisportal
 *   
 *   To run mysql under docker:
 *   docker run --name ssoo-mysql -e MYSQL_ROOT_PASSWORD=password -d -p 3306:3306  mysql:5.7
 *   
 * @author ssoo
 *
 */

@RestController
@RequestMapping("tennisportal")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
		
	@GetMapping("/players")
	public ResponseEntity<Players> getPlayers() {
		ResponseEntity<Players> responseEntity = playerService.getPlayers();
		return responseEntity;
	}
	
	@GetMapping(path="/players/{playerId}")
	public ResponseEntity<Player> getPlayer(@PathVariable Long playerId) throws Exception {		
		 ResponseEntity<Player> responseEntity = playerService.getPlayer(playerId);
		 return responseEntity;
	}
		
	@PostMapping(path = "/players", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Player> savePlayer(@RequestBody Player player) {		
		ResponseEntity<Player> responseEntity = playerService.savePlayer(player);
		return responseEntity;
	}	
}
