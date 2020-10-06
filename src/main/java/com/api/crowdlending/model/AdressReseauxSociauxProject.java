package com.api.crowdlending.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "adress_reseaux_sociaux_project")
@Getter
@Setter
public class AdressReseauxSociauxProject implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String keyMedia;

    @Column(nullable = false)
    private String valueMedia;

    @Column(nullable = false)
    private String linkProject;

    public String getLinkProject() {
		return linkProject;
	}

	public void setLinkProject(String linkProject) {
		this.linkProject = linkProject;
	}

	@OneToOne
    @JoinColumn(name = "token_project", referencedColumnName = "token")
    private Project project ;

}
