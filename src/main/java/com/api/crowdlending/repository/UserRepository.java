package com.api.crowdlending.repository;

import com.api.crowdlending.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginAndPassword(String login, String password);

    Optional<User> findByLogin(String login);

    Optional<User> findByToken(String token);

//
//    @Query(value = "SELECT COUNT(*) AS nbrUsers FROM users WHERE YEAR( date_created ) = YEAR( NOW( ) )", nativeQuery = true)
//    int countNbrUsersForYearCurrent();
//
//    @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -1 YEAR ) )", nativeQuery = true)
//    int countNbrUsersForLast1Year();
//
//    @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -2 YEAR ) )", nativeQuery = true)
//    int countNbrUsersForLast2Year();
//
//    @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -3 YEAR ) )", nativeQuery = true)
//    int countNbrUsersForLast3Year();
//
//    @Query(value = "SELECT COUNT(*) AS nbrUsers FROM  users  WHERE YEAR( date_created ) = YEAR( ADDDATE( CURDATE( ) , INTERVAL -4 YEAR ) )", nativeQuery = true)
//    int countNbrUsersForLast4Year();


}
