package com.pca.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pca.domain.Player;
import com.pca.service.PlayerService;

@RestController
@RequestMapping("/app/rest/player")
public class PlayerResource extends CrudResource<Player, PlayerService>{

	@Autowired
	private PlayerService playerService;
	
	@Override
	public PlayerService getService() {
		// TODO Auto-generated method stub
		return playerService;
	}

}
