package com.pca.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pca.domain.Player;
import com.pca.service.PlayerService;

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
