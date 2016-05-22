package com.pca.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pca.domain.User;

public interface ManagerService extends DefaultModelCrudService<User> {
	
	public User createNewUser (String login, String password, String firstName, String lastName, String email,
            Boolean active, Boolean hasAuthority);

	public User updateUser(long id, String login, String firstName,
			String lastName, String email, Boolean active, Boolean isDoctor);
	
	public boolean isOverlap(String login);

	public boolean isOverlapLogedUser(String username, Long userId);

	public Page<User> findAllManagers(Pageable pageable);	

}
