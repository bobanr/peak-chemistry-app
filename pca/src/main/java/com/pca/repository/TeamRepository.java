package com.pca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pca.domain.Team;

public interface TeamRepository extends JpaSpecificationRepository<Team> {
	
    Page<Team> findByUserId(Long id, Pageable pageable);
}
