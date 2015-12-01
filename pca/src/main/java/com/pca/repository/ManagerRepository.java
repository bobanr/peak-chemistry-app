package com.pca.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.pca.domain.User;

public interface ManagerRepository extends JpaSpecificationRepository<User> {
	
	@Query("select u from User u where u.login = ?1")
	public List <User> findUser(String login);
	
	@Query("select u from User u where u.login = ?1 and u.id <> ?2")
	public List <User> findLogedUser(String login, Long userId);
	
	@Query("select u from User u, UserPermission up where up.user.id = u.id and up.authority.name = 'ROLE_USER'" )
    Page<User> findAllManagers(Pageable pageable);
	
}
