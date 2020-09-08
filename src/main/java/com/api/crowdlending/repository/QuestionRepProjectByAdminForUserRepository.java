package com.api.crowdlending.repository;



import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.QuestionRepProjectByAdminForUserModel;
import com.api.crowdlending.model.user;

import java.util.List;

@Repository
@Table(name = "question_rep_project_by_admin_for_user")
public interface  QuestionRepProjectByAdminForUserRepository extends JpaRepository<QuestionRepProjectByAdminForUserModel, Long> {
	

	// Optional<adressReseauxSociauxProject> findByKeyMedia(String linkSocial); 
	
	// List<QuestionRepProjectByAdminForUserModel>  findByAdminForUser(project  _project); 
	
	@Query(value = "SELECT  *  FROM  question_rep_project_by_admin_for_user  WHERE  token_project=?1   AND token_admin_exp=?2   AND token_user_dest=?3", nativeQuery = true)
    List<QuestionRepProjectByAdminForUserModel> findByAdminForUser(String tokenProject,String tokenAdmin,String tokenUser);
	   
}
