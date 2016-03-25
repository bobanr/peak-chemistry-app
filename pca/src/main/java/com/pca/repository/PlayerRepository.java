package com.pca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.pca.domain.Player;

public interface PlayerRepository extends JpaSpecificationRepository<Player>{
	
	@Query("select p from Player p where p.team.user.id = ?1")
	public List<Player> getAllPlayersForUserId (Long userId);

}
