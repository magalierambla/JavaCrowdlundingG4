package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.*;



import java.util.List;

@Repository
@Table(name = "list_news_project")
public interface  newsProjectRepository extends JpaRepository<newsProjectModel, Long> {
	
	@Query(value = "SELECT  *  FROM  list_news_project   WHERE  token_project=?1  ", nativeQuery = true)
	List<newsProjectModel>  findAllNewsProjectByToken(String tokenProject);

	
	
	

}
