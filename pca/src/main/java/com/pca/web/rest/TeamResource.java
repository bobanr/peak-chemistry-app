package com.pca.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pca.domain.Team;
import com.pca.service.TeamService;

@RestController
@RequestMapping("/app/rest/team")
public class TeamResource extends CrudResource<Team, TeamService> {

	@Autowired
	private TeamService teamService;

	@Override
	public TeamService getService() {
		return teamService;
	}

}
