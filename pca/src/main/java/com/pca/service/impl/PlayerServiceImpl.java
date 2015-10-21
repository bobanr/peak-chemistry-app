package com.pca.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pca.domain.Player;
import com.pca.repository.PlayerRepository;
import com.pca.service.PlayerService;

@Service
public class PlayerServiceImpl extends DefaultModelCrudServiceImpl<Player, PlayerRepository> implements PlayerService{
    
	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	protected PlayerRepository getRepository() {
		// TODO Auto-generated method stub
		return playerRepository;
	}

}
