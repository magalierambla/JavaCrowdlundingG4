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
	@Table(name = "list_commission_project")
	public interface  commisionProjectRepository extends JpaRepository<commissionProjectModel, Long> {

		
		 @Query(value = "SELECT  *  FROM  list_commission_project   WHERE   token_project=?1", nativeQuery = true)
		 List<commissionProjectModel>  findCheckCommissionProject(String tokenProject);		 
		
		

	}
