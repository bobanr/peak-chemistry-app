package com.pca.service;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pca.domain.Team;

public interface TeamService extends DefaultModelCrudService<Team> {
	Page<Team> getMyTeams(Pageable page);
	
	 public Collection<Team> findByUserid(long id);
}
