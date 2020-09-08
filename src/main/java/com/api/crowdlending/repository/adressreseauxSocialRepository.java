package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.adressReseauxSociauxProject;
import com.api.crowdlending.model.project;
import com.api.crowdlending.model.user;

import java.util.List;

@Repository
@Table(name = "adress_reseaux_sociaux_project")
public interface  adressreseauxSocialRepository extends JpaRepository<adressReseauxSociauxProject, Long> {
	

	Optional<adressReseauxSociauxProject> findByKeyMedia(String linkSocial); 
	
	List<adressReseauxSociauxProject>  findBy_project(project  _project); 
	
	@Transactional
    @Modifying
    @Query(value = "DELETE FROM  adress_reseaux_sociaux_project    WHERE  id=?1", nativeQuery = true)
    void  deleteAdressReseauxSociauxProject(Long id);

}

