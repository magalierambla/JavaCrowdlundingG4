package com.api.crowdlending.repository;

import com.api.crowdlending.model.Adminstrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminstrateurRepository extends JpaRepository<Adminstrateur, Long> {

	 Optional<Adminstrateur> findByLoginAndPassword(String login, String password);

	 Optional<Adminstrateur> findByLogin(String login);

	 Optional<Adminstrateur> findByToken(String token);

}
