package com.pca.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pca.domain.Player;

public interface PlayerService extends DefaultModelCrudService<Player>{
	
	List <Player> getAllPlayersForUserId (Long userId);
	
	Page<Player> findPlayersByTeamId(long teamId,Pageable pageable);
	
	public Collection<Player> findByTeamId(long id);
	
}
