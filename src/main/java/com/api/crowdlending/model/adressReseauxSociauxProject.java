package com.api.crowdlending.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.OneToOne;


@Entity
@Table(name = "adress_reseaux_sociaux_project") 
public class adressReseauxSociauxProject implements Serializable{
	
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
    private project _project ;

	public project get_project() {
		return _project;
	}

	public void set_project(project _project) {
		this._project = _project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyMedia() {
		return keyMedia;
	}

	public void setKeyMedia(String keyMedia) {
		this.keyMedia = keyMedia;
	}

	public String getValueMedia() {
		return valueMedia;
	}

	public void setValueMedia(String valueMedia) {
		this.valueMedia = valueMedia;
	}

	

	
    
  

}
