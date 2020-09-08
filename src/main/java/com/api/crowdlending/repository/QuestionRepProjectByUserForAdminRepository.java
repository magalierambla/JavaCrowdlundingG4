package com.api.crowdlending.repository;


import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.QuestionRepProjectByAdminForUserModel;
import com.api.crowdlending.model.QuestionRepProjectByUserForAdminModel;


import java.util.List;

@Repository
@Table(name = "question_rep_project_by_user_for_admin")
public interface  QuestionRepProjectByUserForAdminRepository extends JpaRepository<QuestionRepProjectByUserForAdminModel, Long> {
	

	// Optional<adressReseauxSociauxProject> findByKeyMedia(String linkSocial); 
	
	// List<adressReseauxSociauxProject>  findBy_project(project  _project); 
	
	@Query(value = "SELECT  *  FROM  question_rep_project_by_user_for_admin  WHERE  token_project=?1   AND token_admin_dest=?2   AND token_user_exp=?3", nativeQuery = true)
    List<QuestionRepProjectByUserForAdminModel> findByUserForAdmin(String tokenProject,String tokenAdmin,String tokenUser);

}
