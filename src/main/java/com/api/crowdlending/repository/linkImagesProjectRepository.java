package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.adressReseauxSociauxProject;
import com.api.crowdlending.model.linkImageProject;
import com.api.crowdlending.model.project;

import java.util.List;

@Repository
@Table(name = "list_link_images_project")
public interface  linkImagesProjectRepository extends JpaRepository<linkImageProject, Long> {
	

	Optional<linkImageProject> findByLink(String linkImage); 
	
	List<linkImageProject>  findBy_project(project  _project); 
	
	@Transactional
    @Modifying
    @Query(value = "DELETE FROM  list_link_images_project    WHERE  id=?1", nativeQuery = true)
    void  deleteLinkImageProject(Long id);

}

