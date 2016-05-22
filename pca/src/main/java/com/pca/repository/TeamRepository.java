package com.pca.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.pca.domain.Team;

public interface TeamRepository extends JpaSpecificationRepository<Team> {
	
    Page<Team> findByUserId(Long id, Pageable pageable);
    
    @Query("select t from Team t where t.user.id = ?1")
    public Collection<Team> findByUserid(long id);
    
    Team findByIdAndUserId(Long id, Long userId);
}
