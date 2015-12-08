package com.pca.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pca.domain.Team;

public interface TeamService extends DefaultModelCrudService<Team> {
	Page<Team> getTeamsByManager(Pageable page);
}
