package com.pca.service;

import java.util.List;

import com.pca.domain.Player;

public interface PlayerService extends DefaultModelCrudService<Player>{
	
	List <Player> getAllPlayersForUserId (Long userId);
	
}
