package com.pca.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pca.domain.User;
import com.pca.domain.UserPermission;


/**
 * Spring Data JPA repository for the User entity.
 */
public interface UserRepository extends JpaRepository<User, String> {

       
    @Query("select u from User u where u.active = false and u.dateCreated > ?1")
    List<User> findNotActivatedUsersByCreationDateBefore(Date date);
    
    @Query("select u from User u where u.login = ?1")
    User findUserByLogin(String login);  
    
    @Query("select u from User u where u.id = ?1")
    User findUserById(Long id);
    
    @Query("select up from UserPermission up where up.user.id = ?1")
	List <UserPermission> getPermissionsForUser(Long userId);
}
