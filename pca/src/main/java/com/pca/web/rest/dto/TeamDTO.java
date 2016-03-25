package com.pca.web.rest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TeamDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4277877239335096346L;

	private long id;
	
	private String teamName;
	
	private String homeStadium;
	
	private List <PlayerDTO> players = new ArrayList<PlayerDTO>();
	
	public TeamDTO () {
		
	}
	
	public TeamDTO (long id, String teamName, String homeStadium) {
		this.id = id;
		this.teamName = teamName;
		this.homeStadium = homeStadium;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getHomeStadium() {
		return homeStadium;
	}

	public void setHomeStadium(String homeStadium) {
		this.homeStadium = homeStadium;
	}

	public List<PlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDTO> players) {
		this.players = players;
	}
	
	public void addPlayer (PlayerDTO player){
		players.add(player);
	}

}
