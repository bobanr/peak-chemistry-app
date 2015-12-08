package com.pca.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pca.domain.Team;
import com.pca.domain.User;
import com.pca.repository.TeamRepository;
import com.pca.repository.UserRepository;
import com.pca.security.SecurityUtils;
import com.pca.service.TeamService;

@Service
public class TeamServiceImpl extends
		DefaultModelCrudServiceImpl<Team, TeamRepository> implements
		TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	protected TeamRepository getRepository() {
		return teamRepository;
	}

	@Override
	public Page<Team> getTeamsByManager(Pageable page) {
		User user = userRepository.findUserByLogin(SecurityUtils
				.getCurrentLogin());
		return teamRepository.findByUserId(user.getId(), page);
	}

}
