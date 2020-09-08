package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.adminstrateur;
import com.api.crowdlending.model.project;
import com.api.crowdlending.model.user;

import java.util.List;

@Repository
@Table(name = "adminstrateurs")
public interface  adminstrateurRepository extends JpaRepository<adminstrateur, Long> {
	

	Optional<adminstrateur> findByLogin(String nomLogin); 
	
	
	 @Query(value = "SELECT  *  FROM  adminstrateurs  WHERE  login=?1  AND  password=?2", nativeQuery = true)
	 adminstrateur getUserByEmailAndPassword(String login, String password);
	   
	 @Query(value = "SELECT  *  FROM  adminstrateurs  WHERE  login=?1 ", nativeQuery = true)
	 adminstrateur checkExistMailUser(String login);
	   
	  @Query(value = "SELECT  *  FROM  adminstrateurs  WHERE  token=?1 ", nativeQuery = true)
      Optional<adminstrateur> checkExistUserByToken(String token);
	
	

}
