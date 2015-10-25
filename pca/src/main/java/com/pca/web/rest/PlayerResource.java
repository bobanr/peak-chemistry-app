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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pca.domain.Player;
import com.pca.service.PlayerService;
import com.pca.web.util.RequestProcessor;

@Controller
@RequestMapping("/app/rest/player")
public class PlayerResource extends CrudResource<Player, PlayerService>{

	@Autowired
	private PlayerService playerService;
	
	@Override
	public PlayerService getService() {
		// TODO Auto-generated method stub
		return playerService;
	}
	
	/*@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Player> saveOrUpdate(@RequestBody @Valid Player player, HttpServletResponse response) {
		playerService.saveAndFlush(player);
		return new ResponseEntity<>(player, HttpStatus.OK);
		
	}
	
	 @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	    public List<Player> getAll() {
	        Collection<Player> all = playerService.findAll();
	        return all == null ? new ArrayList<Player>() : new ArrayList<Player>(all);
	    }
	 
	  @RequestMapping(value = "/paged", method = RequestMethod.GET, produces = "application/json")
	    public Page<Player> getAll(@RequestParam int page, @RequestParam int count, HttpServletRequest request) {
	        Sort sort = RequestProcessor.sorting(request);
	        Pageable pageable = new PageRequest(page - 1, count, sort);
	        return playerService.findAll(pageable);
	    }
*/
	

}
