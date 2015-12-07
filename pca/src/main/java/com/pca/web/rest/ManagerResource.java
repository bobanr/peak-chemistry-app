package com.pca.web.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pca.domain.User;
import com.pca.service.ManagerService;
import com.pca.web.rest.dto.UserDTO;
import com.pca.web.util.RequestProcessor;

@RestController
@RequestMapping("app/rest/manager")
public class ManagerResource {

	@Autowired
	private ManagerService managerService;

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public void create(@RequestBody @Valid UserDTO userDTO,
			HttpServletRequest request, HttpServletResponse response) {
		String username = userDTO.getLogin();
		if (managerService.isOverlap(username)) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		} else {
			managerService.createNewUser(userDTO.getLogin(),
					userDTO.getPassword(), userDTO.getFirstName(),
					userDTO.getLastName(), userDTO.getEmail(),
					userDTO.getActive(), userDTO.getHasAuthory());
			response.setStatus(HttpServletResponse.SC_CREATED);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@RequestBody @Valid User user,
			HttpServletRequest request, HttpServletResponse response) {
		String username = user.getLogin();
		Long userId = user.getId();
		if (managerService.isOverlapLogedUser(username, userId)) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		} else {
			managerService.updateUser(user.getId(), user.getLogin(),
					user.getFirstName(), user.getLastName(), user.getEmail(),
					user.getActive(), user.getHasAuthority());
		}
	}

	@RequestMapping(value = "/paged", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page <User> getAllManagers(@RequestParam int page,
			@RequestParam int count, HttpServletRequest request) {
		Sort sort = RequestProcessor.sorting(request);
		Pageable pageable = new PageRequest(page - 1, count, sort);
		return managerService.findAll(pageable);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public User get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		User user = managerService.findById(id);
		if (user == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return user;
	}

	@RequestMapping(value = "remove/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		managerService.delete(id);
	}
}