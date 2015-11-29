package com.pca.repository;

import com.pca.domain.User;

import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface UserRepository extends JpaRepository<User, String> {

       
    @Query("select u from User u where u.active = false and u.dateCreated > ?1")
    List<User> findNotActivatedUsersByCreationDateBefore(Date date);
    
    @Query("select u from User u where u.login = ?1")
    User findUserByLogin(String login);  
    
   
}
