package com.pca.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pca.domain.Team;
import com.pca.repository.TeamRepository;
import com.pca.service.PlayerService;
import com.pca.service.TeamService;

@Service
public class TeamServiceImpl extends
		DefaultModelCrudServiceImpl<Team, TeamRepository> implements
		TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Override
	protected TeamRepository getRepository() {
		return teamRepository;
	}

}
