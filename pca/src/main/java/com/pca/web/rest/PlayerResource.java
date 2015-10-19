package com.pca.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pca.domain.Players;
import com.pca.service.PlayerService;

@Controller
@RequestMapping("/app/rest/player")
public class PlayerResource extends CrudResource<Players, PlayerService>{

	@Autowired
	private PlayerService playerService;
	
	@Override
	public PlayerService getService() {
		return playerService;
	}

}
