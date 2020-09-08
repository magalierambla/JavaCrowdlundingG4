package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.statutProject;

import java.util.List;

@Repository
@Table(name = "list_statut_project")
public interface  statutProjectRepository extends JpaRepository<statutProject, Long> {
	

	Optional<statutProject> findByNom(String nomPorte); 

}