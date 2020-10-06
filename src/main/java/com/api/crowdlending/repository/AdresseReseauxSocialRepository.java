package com.api.crowdlending.repository;

import com.api.crowdlending.model.AdressReseauxSociauxProject;
import com.api.crowdlending.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdresseReseauxSocialRepository extends JpaRepository<AdressReseauxSociauxProject, Long> {

	Optional<AdressReseauxSociauxProject> findByKeyMedia(String keyMedia);

	List<AdressReseauxSociauxProject> findByProject(Project project);

	@Transactional
    @Modifying
    @Query(value = "DELETE FROM  adress_reseaux_sociaux_project    WHERE  id=?1", nativeQuery = true)
    void  deleteAdressReseauxSociauxProject(Long id);

}

