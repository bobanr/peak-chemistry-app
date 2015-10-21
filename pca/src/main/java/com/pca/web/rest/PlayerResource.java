package com.pca.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pca.domain.Player;
import com.pca.service.PlayerService;

@Controller
@RequestMapping("/app/rest/player")
public class PlayerResource extends CrudResource<Player, PlayerService>{

	@Autowired
	private PlayerService playerService;
	
	@Override
	public PlayerService getService() {
		return playerService;
	}

}
