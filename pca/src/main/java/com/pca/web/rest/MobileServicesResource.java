package com.pca.web.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pca.domain.Player;
import com.pca.domain.User;
import com.pca.domain.UserPermission;
import com.pca.repository.UserRepository;
import com.pca.security.AuthoritiesConstants;
import com.pca.service.PlayerService;
import com.pca.service.impl.ManagerServiceImpl;
import com.pca.web.rest.dto.JsonObjectDTO;
import com.pca.web.rest.dto.ManagerDTO;
import com.pca.web.rest.dto.MatchDTO;
import com.pca.web.rest.dto.PlayerDTO;
import com.pca.web.rest.dto.TeamDTO;

@RestController
@RequestMapping("app/rest/mobile")
public class MobileServicesResource {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private UserRepository userRepository;

	@Inject
	private PasswordEncoder passwordEncoder;
	
	private final Logger log = LoggerFactory.getLogger(ManagerServiceImpl.class);

	private ManagerDTO getManagerWithTeams(User user) {

		log.info(String.format("getManagerWithTeams for userId: %s", user.getId()));
		ManagerDTO manager = new ManagerDTO(user.getId(), user.getFirstName(), user.getLastName());

		List<Player> players = playerService.getAllPlayersForUserId(user.getId());
		HashMap<Long, TeamDTO> teams = new HashMap<Long, TeamDTO>();

		for (Player temp : players) {

			TeamDTO team = new TeamDTO(temp.getTeam().getId(), temp.getTeam().getTeamName(),
					temp.getTeam().getHomeStadium());

			PlayerDTO player = new PlayerDTO(temp.getId(), temp.getFirstName(), temp.getLastName(),
					temp.getShirtNumber());

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

		if (teams.size() > 0) {
			manager.setTeams(new ArrayList<>(teams.values()));
		}

		log.info(String.format("getManagerWithTeams for userId: %s successfully executed", user.getId()));
		return manager;
	}

	@RequestMapping(value = "/myteams", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<JsonObjectDTO> getMyTeams(@RequestParam long userId) {

		log.info(String.format("myteams for userId: %s",userId));
		JsonObjectDTO response = new JsonObjectDTO();

		try {
			User user = userRepository.findUserById(userId);
			if (user == null || !user.getActive()) {
				throw new Exception(String.format("User with id: %s not found or not active.", userId));
			}

			// check if user has the role: ROLE_USER
			List<UserPermission> permissions = userRepository.getPermissionsForUser(user.getId());
			boolean roleUserFound = false;

			for (UserPermission userPermission : permissions) {
				if (userPermission.getAuthority().getName().equals(AuthoritiesConstants.USER)) {
					roleUserFound = true;
					break;
				}
			}

			if (!roleUserFound) {
				throw new Exception(String.format("User with id: %s not found.", userId));
			}

			response.setSuccess(true);
			response.setData(getManagerWithTeams(user));
			log.info(String.format("myteams for userId: %s successfully executed",userId));
			return new ResponseEntity<JsonObjectDTO>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			log.error(String.format("myteams for userId: %s throws error: %s", userId, e.getMessage()));
			return new ResponseEntity<JsonObjectDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<JsonObjectDTO> login(String login, String password) {

		log.info(String.format("login for username: %s", login));
		JsonObjectDTO response = new JsonObjectDTO();

		try {
			User user = userRepository.findUserByLogin(login);
			if (user == null || !user.getActive()) {
				response.setSuccess(false);
				response.setMessage("Wrong username or password");
				return new ResponseEntity<JsonObjectDTO>(response, HttpStatus.OK);
			}

			// check if user has the role: ROLE_USER
			List<UserPermission> permissions = userRepository.getPermissionsForUser(user.getId());
			boolean roleUserFound = false;

			for (UserPermission userPermission : permissions) {
				if (userPermission.getAuthority().getName().equals(AuthoritiesConstants.USER)) {
					roleUserFound = true;
					break;
				}
			}

			if (!roleUserFound) {
				response.setSuccess(false);
				response.setMessage("Wrong username or password");
				log.info(String.format("login for username: %s user don't have permissions", login));
				return new ResponseEntity<JsonObjectDTO>(response, HttpStatus.OK);
			}

			if (!passwordEncoder.matches(password, user.getPassword())) {
				response.setSuccess(false);
				response.setMessage("Wrong username or password");
				log.info(String.format("login for username: %s wrong username or password", login));
				return new ResponseEntity<JsonObjectDTO>(response, HttpStatus.OK);
			}

			response.setSuccess(true);
			response.setData(getManagerWithTeams(user));
			log.info(String.format("login for username: %s successfully executed", login));
			return new ResponseEntity<JsonObjectDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			log.error(String.format("login for username: %s throws error: %s", login, e.getMessage()));
			return new ResponseEntity<JsonObjectDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping(value = "/match", method = RequestMethod.POST, produces = "application/json")
	public void addMatch (@RequestParam MatchDTO match) {
		
		log.info(String.format("Call match service"));
	}

}
