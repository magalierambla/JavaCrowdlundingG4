package com.api.crowdlending.repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Optional;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.crowdlending.model.StatistiquesChartsUsersModel;
import com.api.crowdlending.model.user;

@Repository
@Table(name = "users")
public interface  userRepository extends JpaRepository<user, Long> {
	
	  
	  
	

	   @Query(value = "SELECT COUNT(*) AS nbr_items FROM  users", nativeQuery = true)
	   Long countItem();
	   
	   @Query(value = "SELECT  *  FROM  users  WHERE  login=?1  AND  password=?2", nativeQuery = true)
	   user getUserByEmailAndPassword(String login, String password);
	   
	   @Query(value = "SELECT  *  FROM  users  WHERE  login=?1 ", nativeQuery = true)
	   user checkExistMailUser(String login);
	   
	   @Query(value = "SELECT  *  FROM  users  WHERE  token=?1 ", nativeQuery = true)
	   Optional<user> checkExistUserByToken(String token);
	   
	   @Query(value = "SELECT COUNT(*) AS nbrUsers FROM users WHERE YEAR( date_created ) = YEAR( NOW( ) )", nativeQuery = true)
	   int  countNbrUsersForYearCurrent();
	   
	   @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -1 YEAR ) )", nativeQuery = true)
	   int  countNbrUsersForLast1Year();
	   
	   @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -2 YEAR ) )", nativeQuery = true)
	   int  countNbrUsersForLast2Year();
	   
	   @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -3 YEAR ) )", nativeQuery = true)
	   int  countNbrUsersForLast3Year();
	   
	   @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -4 YEAR ) )", nativeQuery = true)
	   int  countNbrUsersForLast4Year();
	   
	  

}
