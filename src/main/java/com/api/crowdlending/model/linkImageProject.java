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
@Table(name = "list_link_images_project")
public class linkImageProject implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String link;    
    
    
    @OneToOne
    @JoinColumn(name = "token_project", referencedColumnName = "token")
    private project _project ;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public project get_project() {
		return _project;
	}


	public void set_project(project _project) {
		this._project = _project;
	}

	

	

	
    
  

}
