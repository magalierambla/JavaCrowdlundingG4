package com.api.crowdlending.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.project;

import com.api.crowdlending.model.user;

import com.api.crowdlending.model.favorisProjectUserModel;



@Repository
@Table(name = "projects")
public interface  projectRepository extends JpaRepository<project, Long> {
	
	
	 List<project>  findBy_user(user _user); 
	 
	 Optional<project>  findByToken(String token); 
	 
	 @Query(value = "SELECT * FROM projects LEFT JOIN adminstrateurs ON projects.token_manager = adminstrateurs.token", nativeQuery = true)
	 List<project> findAllProjects();
	 
	 @Query(value = "SELECT * FROM projects    WHERE statut_project  IN ('2','5','6')  ", nativeQuery = true)
	 List<project> findAllProjectsForVisitor();
	
	 @Query(value = "SELECT  *  FROM  projects  WHERE  token_user=?1", nativeQuery = true)
	 List<project> findAllProjectByToken(String tokenUser);
	 
	 @Query(value = "SELECT  *  FROM  projects  WHERE  token=?1", nativeQuery = true)
	 project findProjectByToken(String tokenProject);
	 
	 @Query(value = "SELECT * FROM  projects  WHERE  statut_project  IN ('2','5','6')  AND token_user != ?1", nativeQuery = true)
	 List<project> findAllProjectsByUser(String tokenUser); 
	 
	 @Query(value = "SELECT * FROM  projects  WHERE nom  LIKE   ?1  OR  description  LIKE   ?1 ", nativeQuery = true)
	 List<project> findAllProjectsByLikeTag(@Param("tag") String tag); 
	 
	 List<project> findByNomLike(String tag);
	 
	 
	 // SELECT * FROM  projects  WHERE nom  LIKE   '%1%'  OR  description  LIKE   '%1%'
	 

	 
	 
	  
	
	
	  
	   
	  /*  @Query(value = "SELECT  *  FROM  users  WHERE  login=?1 ", nativeQuery = true)
	   user checkExistMailUser(String login);
	   
	   @Query(value = "SELECT  *  FROM  users  WHERE  token=?1 ", nativeQuery = true)
	   Optional<user> checkExistUserByToken(String token);*/

}
