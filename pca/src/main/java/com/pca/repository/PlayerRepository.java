package com.pca.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.pca.domain.Player;

public interface PlayerRepository extends JpaSpecificationRepository<Player>{
	
	@Query("select p from Player p where p.team.user.id = ?1")
	public List<Player> getAllPlayersForUserId (Long userId);
	
	@Query("select p from Player p where p.team.id = ?1")
    Page<Player> findPlayersByTeamId(long teamId,Pageable pageable);
	
	@Query("select p from Player p where p.team.id = ?1")
    public Collection<Player> findByTeamId(long id);

}
