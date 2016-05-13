package com.pca.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Player> findPlayersByTeamId(long teamId,Pageable pageable) {
		return playerRepository.findPlayersByTeamId(teamId, pageable);
	}

	@Override
	public Collection<Player> findByTeamId(long id) {
		
		return playerRepository.findByTeamId(id);
	}
}
