package com.pca.web.rest;

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
import com.pca.service.PlayerService;
import com.pca.web.util.RequestProcessor;

@RestController
@RequestMapping("/app/rest/player")
public class PlayerResource extends CrudResource<Player, PlayerService>{

	@Autowired
	private PlayerService playerService;
	
	@Override
	public PlayerService getService() {
		// TODO Auto-generated method stub
		return playerService;
	}
	
	 @RequestMapping(value = "/getPlayersByTeamId", method = RequestMethod.GET, produces = "application/json")
	    public Page<Player> getPlayersByTeamId(@RequestParam int page, @RequestParam int count,@RequestParam long teamId, HttpServletRequest request) {
	        Sort sort = RequestProcessor.sorting(request);
	        Pageable pageable = new PageRequest(page - 1, count, sort);
	        return getService().findPlayersByTeamId(teamId, pageable);
	    }

}
