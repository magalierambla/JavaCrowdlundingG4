package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.*;



import java.util.List;

@Repository
@Table(name = "hearts_project_user")
public interface  heartsProjectRepository extends JpaRepository<heartProjectModel, Long> {

	
	 @Query(value = "SELECT  *  FROM  hearts_project_user   WHERE  token_user=?1  AND token_project=?2", nativeQuery = true)
	 List<heartProjectModel>  findCheckHeartProject(String tokenUser,String tokenProject);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "DELETE FROM  hearts_project_user    WHERE  token_user=?1  AND token_project=?2", nativeQuery = true)
	 void  deleteHeartProject(String tokenUser,String tokenProject);
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  hearts_project_user   WHERE   token_project=?1", nativeQuery = true)
	 int   countHeartProject(String tokenProject);
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  hearts_project_user   WHERE   token_project=?1  AND  MONTH( created_at ) = ?2   AND YEAR( created_at ) = ?3 ", nativeQuery = true)
	 int   countHeartProjectByMonthANDYear(String tokenProject, String month, int year);
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  hearts_project_user   WHERE DATE_FORMAT(created_at, \"%e\") = ?1  AND MONTH( created_at ) = ?2   AND YEAR( created_at ) = ?3  AND   token_project=?4 ", nativeQuery = true)
	 int   countHeartProjectByMonthANDYearByDays(int days, int month, int year, String tokenProject);
	 
	 // SELECT * FROM hearts_project_user  WHERE DATE_FORMAT(created_at, "%e") = ?1  AND MONTH( created_at ) = ?2   AND YEAR( created_at ) = ?3  AND   token_project=?4
	

}
