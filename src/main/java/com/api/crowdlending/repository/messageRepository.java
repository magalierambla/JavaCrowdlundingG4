package com.api.crowdlending.repository;

import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.messageModel;
import com.api.crowdlending.model.project;

import java.util.List;

@Repository
@Table(name = "messagerie_interne")
public interface  messageRepository extends JpaRepository<messageModel, Long> {
	

	 @Query(value = "SELECT  *  FROM  messagerie_interne  WHERE  _token_user_dest=?1", nativeQuery = true)
	 List<messageModel> findAllMessagesRecusByTokenUser(String tokenUser);
	 
	 
	 @Query(value = "SELECT  *  FROM  messagerie_interne  WHERE  _token_user_exp=?1", nativeQuery = true)
	 List<messageModel> findAllMessagesEnvoyesByTokenUser(String tokenUser);

}
