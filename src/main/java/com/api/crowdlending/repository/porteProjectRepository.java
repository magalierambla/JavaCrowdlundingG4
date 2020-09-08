package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.porte_project;

import java.util.List;

@Repository
@Table(name = "list_porte_project")
public interface  porteProjectRepository extends JpaRepository<porte_project, Long> {
	

	Optional<porte_project> findByNom(String nomPorte); 	
	  

}


