package com.pca.web.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pca.domain.Player;
import com.pca.domain.Team;
import com.pca.domain.User;
import com.pca.repository.UserRepository;
import com.pca.service.PlayerService;
import com.pca.web.rest.dto.ManagerDTO;
import com.pca.web.rest.dto.PlayerDTO;
import com.pca.web.rest.dto.TeamDTO;
import com.pca.web.util.RequestProcessor;

@RestController
@RequestMapping("app/rest/mobile")
public class MobileServicesResource {

	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private UserRepository userRepository;
	
	private ManagerDTO getManagerWithTeams(Long userId) throws Exception {

		User u = userRepository.findUserById(userId);
		if (u == null) {
			throw new Exception(String.format("User with id: %s not found.", userId));
		}
		
		ManagerDTO manager = new ManagerDTO(u.getId(), u.getFirstName(), u.getLastName());
		
		List<Player> players = playerService.getAllPlayersForUserId(u.getId());
		HashMap<Long, TeamDTO> teams = new HashMap<Long, TeamDTO>();
		
		for (Player temp : players) {
			
			TeamDTO team = new TeamDTO(temp.getTeam().getId(), temp.getTeam().getTeamName(),
					temp.getTeam().getHomeStadium());
			
			PlayerDTO player = new PlayerDTO(temp.getId(), temp.getFirstName(), temp.getLastName(), temp.getShirtNumber());
			
			TeamDTO checkTeam = teams.get(team.getId());
			
			if (checkTeam != null) {
				// Team is already in HashMap, add player to team
				checkTeam.addPlayer(player);
			} else {
				// Team is not in HashMap, add team to hash map and add player
				// to team
				team.addPlayer(player);
				teams.put(team.getId(), team);
			}
			
		}
		
		if (teams.size()>0){
			manager.setTeams(new ArrayList<>(teams.values()));
		}
		
		return manager;
	}
	
	@RequestMapping(value = "/myteams", method = RequestMethod.GET, produces = "application/json")
	public ManagerDTO getMyTeams(@RequestParam long userId) throws Exception {
		return getManagerWithTeams(userId);
	}
	
	

}
