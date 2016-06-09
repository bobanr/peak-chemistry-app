package com.pca.web.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pca.domain.Matches;
import com.pca.domain.Passes;
import com.pca.domain.Player;
import com.pca.domain.PlayerStatistics;
import com.pca.domain.Team;
import com.pca.domain.User;
import com.pca.domain.UserPermission;
import com.pca.repository.UserRepository;
import com.pca.security.AuthoritiesConstants;
import com.pca.service.MatchesService;
import com.pca.service.PassesService;
import com.pca.service.PlayerService;
import com.pca.service.PlayerStatisticsService;
import com.pca.service.TeamService;
import com.pca.service.impl.ManagerServiceImpl;
import com.pca.web.rest.dto.JsonObjectDTO;
import com.pca.web.rest.dto.ManagerDTO;
import com.pca.web.rest.dto.MatchDTO;
import com.pca.web.rest.dto.PassesDTO;
import com.pca.web.rest.dto.PlayerDTO;
import com.pca.web.rest.dto.PlayerStatisticsDTO;
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

	@Autowired
	private TeamService teamService;

	@Autowired
	private MatchesService matchesService;

	@Autowired
	private PassesService passesService;

	@Autowired
	private PlayerStatisticsService playerStatisticsService;

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

		log.info(String.format("myteams for userId: %s", userId));
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
			log.info(String.format("myteams for userId: %s successfully executed", userId));
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
			return new ResponseEntity<JsonObjectDTO>(response, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/match", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<JsonObjectDTO> addMatch(@RequestBody MatchDTO match) {

		log.info(String.format("Call match service: %s", match.toString()));
		JsonObjectDTO response = new JsonObjectDTO();
		
		try {

		    Long matchId = saveMatch(match);
			response.setSuccess(true);
			response.setData(matchId);
			log.error(String.format("SUCCESS match service for team with id %s and userId= %s saved in DB with matchID: %s",
					match.getTeamId(), match.getUserId(), matchId));
			return new ResponseEntity<JsonObjectDTO>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			log.error(String.format("match service for team with id %s and userId= %s throws error: %s",
					match.getTeamId(), match.getUserId(), e.getMessage()));
			return new ResponseEntity<JsonObjectDTO>(response, HttpStatus.OK);
		}

	}

	@Transactional(rollbackFor = Exception.class)
	private Long saveMatch(MatchDTO match) throws Exception {

		// Find the team
		Team team = teamService.findByIdAndUserId(match.getTeamId(), match.getUserId());
		if (team == null) {
			throw new Exception(
					String.format("Team with id %s and userId= %s not found", match.getTeamId(), match.getUserId()));
		}

		DateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		// Create the match in DB
		Matches matches = matchesService.saveAndFlush(new Matches(match.getOpponentName(), match.getStadiumName(),
				match.getFormation(), formater.parse(match.getMatchTime()), team, match.getGoals(), match.getOpponentGoals()));

		// save the passes for the match
		List<Passes> passes = new ArrayList<Passes>();
		for (PassesDTO pass : match.getPasses()) {
			passes.add(new Passes(pass.getFromNumber(), pass.getFromNumber(), pass.getPassTime(), matches));
		}

		if (passes.size() > 0) {
			passesService.save(passes);
		}

		// save the player statistic for the match
		HashMap<Long, Player> teamPlayers = new HashMap<Long, Player>();
		Collection<Player> players = playerService.findByTeamId(match.getTeamId());
		for (Player player : players) {
			teamPlayers.put(player.getId(), player);
		}

		List<PlayerStatistics> statistics = new ArrayList<PlayerStatistics>();
		for (PlayerStatisticsDTO statistic : match.getStatistics()) {

			Player player = teamPlayers.get(statistic.getPlayerId());
			Player withPlayer = null;
			if (statistic.getWithPlayerId() != null) {
				withPlayer = teamPlayers.get(statistic.getWithPlayerId());
			}
			statistics.add(new PlayerStatistics(statistic.getStatisticType(), statistic.getMinute(), player, withPlayer,
					matches));
		}

		if (statistics.size() > 0) {
			playerStatisticsService.save(statistics);
		}
		
		return matches.getId();
	}

}
