package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.*;



import java.util.List;

@Repository
@Table(name = "fonds_investisseurs_paypal")
public interface  fondInvestorRepository extends JpaRepository<fondInvestorModel, Long> {

	
	
	List<fondInvestorModel>  findBy_project(project  _project); 
	
	List<fondInvestorModel>  findBy_user(user  _user); 
	
	   @Query(value = "SELECT  *  FROM  fonds_investisseurs_paypal  WHERE  token=?1 ", nativeQuery = true)
	   Optional<fondInvestorModel> checkExistFondProjectByToken(String token);

}
