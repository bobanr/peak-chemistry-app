package com.pca.web.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pca.domain.Team;
import com.pca.domain.User;
import com.pca.repository.UserRepository;
import com.pca.security.SecurityUtils;
import com.pca.service.TeamService;
import com.pca.web.util.RequestProcessor;

@RestController
@RequestMapping("/app/rest/team")
public class TeamResource extends CrudResource<Team, TeamService> {

	@Autowired
	private TeamService teamService;

	@Autowired
	private UserRepository userRepository;

	@Override
	public TeamService getService() {
		return teamService;
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public Team create(@RequestBody @Valid Team entity,
			HttpServletRequest request, HttpServletResponse response) {
		User user = userRepository.findUserByLogin(SecurityUtils
				.getCurrentLogin());
		entity.setUser(user);
		beforeSave(entity);
		getService().saveAndFlush(entity);
		return entity;
	}

	@RequestMapping(value = "/myteams", method = RequestMethod.GET, produces = "application/json")
	public Page<Team> getMyTeams(@RequestParam int page,
			@RequestParam int count, HttpServletRequest request) {
		Sort sort = RequestProcessor.sorting(request);
		Pageable pageable = new PageRequest(page - 1, count, sort);
		return getService().getMyTeams(pageable);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Team> getAll() {
		User user = userRepository.findUserByLogin(SecurityUtils
				.getCurrentLogin());
		long id = user.getId();
        Collection<Team> all = getService().findByUserid(id);
        return all == null ? new ArrayList<Team>() : new ArrayList<Team>(all);
    }

}
