package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.*;



import java.util.List;

@Repository
@Table(name = "list_users_vues_project")
public interface  vueProjectRepository extends JpaRepository<vueProjectModel, Long> {

	
	 @Query(value = "SELECT  *  FROM  list_users_vues_project   WHERE  token_user=?1  AND token_project=?2", nativeQuery = true)
	 List<vueProjectModel>  findCheckVueProject(String tokenUser,String tokenProject);	 
	 
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  list_users_vues_project   WHERE   token_project=?1  ", nativeQuery = true)
	 int   countVuesProject(String tokenProject); 
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  list_users_vues_project   WHERE   token_project=?1  AND  MONTH( created_at ) = ?2   AND YEAR( created_at ) = ?3 ", nativeQuery = true)
	 int   countVuesProjectByMonthANDYear(String tokenProject, String month, int year);
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  list_users_vues_project   WHERE DATE_FORMAT(created_at, \"%e\") = ?1  AND MONTH( created_at ) = ?2   AND YEAR( created_at ) = ?3  AND   token_project=?4 ", nativeQuery = true)
	 int   countVuesProjectByMonthANDYearByDays(int days, int month, int year, String tokenProject);
	 
	
	
	

}
