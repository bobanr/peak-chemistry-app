package com.pca.service.impl;

import java.util.List;

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
		return playerRepository;
	}

	@Override
	public List<Player> getAllPlayersForUserId(Long userId) {
		
		return playerRepository.getAllPlayersForUserId(userId);
		
	}	
}
