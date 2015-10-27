package com.pca.repository;

import com.pca.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
	
	@Query("select a from Authority a where a.name = ?1")
	Authority findAutorityByName (String name);
}
