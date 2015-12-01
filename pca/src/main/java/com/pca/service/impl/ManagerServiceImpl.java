package com.pca.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;












import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pca.domain.Authority;
import com.pca.domain.User;
import com.pca.domain.UserPermission;
import com.pca.repository.AuthorityRepository;
import com.pca.repository.ManagerRepository;
import com.pca.repository.UserPermissionRepository;
import com.pca.repository.UserRepository;
import com.pca.service.ManagerService;

@Service
@Transactional
public class ManagerServiceImpl extends DefaultModelCrudServiceImpl<User, ManagerRepository> implements ManagerService{

	
	private final Logger log = LoggerFactory.getLogger(ManagerServiceImpl.class);
	
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private UserPermissionRepository userPermissionRepository;
	
	
	@Override
	protected ManagerRepository getRepository() {
		return managerRepository;
	}
	
	@Override
	public User createNewUser(String login, String password, String firstName,
			String lastName, String email, Boolean active, Boolean hasAuthority) {
		// TODO Auto-generated method stub
		User newUser = new User();
	    Authority authority = authorityRepository.findAutorityByName("ROLE_USER");
	    Set<Authority> authorities = new HashSet<Authority>();
	    String encryptedPassword = passwordEncoder.encode(password);
	    newUser.setLogin(login);
	    // new user gets initially a generated password
	    newUser.setPassword(encryptedPassword);
	    newUser.setFirstName(firstName);
	    newUser.setLastName(lastName);
	    newUser.setEmail(email);
	    // new user is not active
	    newUser.setActive(active);
	    // new user gets registration key
	    newUser.setHasAuthority(hasAuthority);
//	    authorities.add(authority);
	//    
//	    newUser.setAuthorities(authorities);
	    
	    managerRepository.saveAndFlush(newUser);
		UserPermission up = new UserPermission();
		up.setAuthority(authority);
		up.setUser(newUser);
		userPermissionRepository.saveAndFlush(up);
		log.debug("Created Information for User: {}", newUser);       
	    return newUser;
	}

	@Override
	public User updateUser(long id, String login, String firstName,
			String lastName, String email, Boolean active, Boolean hasAuthority) {
		
		User currentUser = managerRepository.findOne(id);
		currentUser.setLogin(login);
		currentUser.setFirstName(firstName);
		currentUser.setLastName(lastName);
		currentUser.setEmail(email);
		currentUser.setActive(active);
		currentUser.setHasAuthority(hasAuthority);
		userRepository.save(currentUser);
		log.debug("Changed Information for User: {}", currentUser);
		return currentUser;	
	}

	@Override
	public boolean isOverlap(String login) {
		List<User> list = new ArrayList<User>();
		list = managerRepository.findUser(login);
		if(list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isOverlapLogedUser(String username, Long userId) {
		List<User> list = new ArrayList<User>();
		list = managerRepository.findLogedUser(username, userId);
		if(list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	

	@Override
	public Page<User> findAllManagers(Pageable pageable) {
		
		return managerRepository.findAllManagers(pageable);
	}

}
