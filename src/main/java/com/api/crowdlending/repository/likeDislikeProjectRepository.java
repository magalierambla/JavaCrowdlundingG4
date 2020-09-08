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
@Table(name = "like_dislike_project_user")
public interface  likeDislikeProjectRepository extends JpaRepository<likeDislikeProjectModel, Long> {

	
	 @Query(value = "SELECT  *  FROM  like_dislike_project_user   WHERE  token_user=?1  AND token_project=?2", nativeQuery = true)
	 List<likeDislikeProjectModel>  findCheckLikeProject(String tokenUser,String tokenProject);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "DELETE FROM  like_dislike_project_user    WHERE  token_user=?1  AND token_project=?2", nativeQuery = true)
	 void  deleteLikeProject(String tokenUser,String tokenProject);
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  like_dislike_project_user   WHERE   token_project=?1  AND statut_like_project='LIKE' ", nativeQuery = true)
	 int   countLikeProject(String tokenProject);
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  like_dislike_project_user   WHERE   token_project=?1  AND statut_like_project='DISLIKE' ", nativeQuery = true)
	 int   countDisLikeProject(String tokenProject);
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  like_dislike_project_user   WHERE   token_project=?1  AND  MONTH( created_at ) = ?2   AND YEAR( created_at ) = ?3  AND statut_like_project='LIKE' ", nativeQuery = true)
	 int   countLikesProjectByMonthANDYear(String tokenProject, String month, int year);
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  like_dislike_project_user   WHERE   token_project=?1  AND  MONTH( created_at ) = ?2   AND YEAR( created_at ) = ?3  AND statut_like_project='DISLIKE' ", nativeQuery = true)
	 int   countDislikesProjectByMonthANDYear(String tokenProject, String month, int year);
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  like_dislike_project_user   WHERE DATE_FORMAT(created_at, \"%e\") = ?1  AND MONTH( created_at ) = ?2   AND YEAR( created_at ) = ?3  AND   token_project=?4 AND statut_like_project='LIKE' ", nativeQuery = true)
	 int   countLikeProjectByMonthANDYearByDays(int days, int month, int year, String tokenProject);
	 
	 @Query(value = "SELECT  COUNT(*)  FROM  like_dislike_project_user   WHERE DATE_FORMAT(created_at, \"%e\") = ?1  AND MONTH( created_at ) = ?2   AND YEAR( created_at ) = ?3  AND   token_project=?4 AND statut_like_project='DISLIKE' ", nativeQuery = true)
	 int   countDislikeProjectByMonthANDYearByDays(int days, int month, int year, String tokenProject);
	

}
