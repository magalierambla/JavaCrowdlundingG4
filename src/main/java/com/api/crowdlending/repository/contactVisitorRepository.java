package com.api.crowdlending.repository;


import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.*;



import java.util.List;

@Repository
@Table(name = "contact_visitors")
public interface  contactVisitorRepository extends JpaRepository<contactModel, Long> {	
	
	

}
