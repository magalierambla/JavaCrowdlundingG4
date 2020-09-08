package com.api.crowdlending.model;

import java.io.Serializable;

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
@Table(name = "question_rep_project_by_user_for_admin")
public class  QuestionRepProjectByUserForAdminModel implements Serializable{
	
    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bodyAide;
    
    @Column(nullable = false)
    private String dateCreated;
    
    @Column(nullable = false)
    private Long timestamp;
    
    @OneToOne
    @JoinColumn(name = "token_project", referencedColumnName = "token")
    private project _project ;
    
    @OneToOne
    @JoinColumn(name = "token_admin_dest", referencedColumnName = "token")
    private adminstrateur _userAdminDest;   
    

	@OneToOne
    @JoinColumn(name = "token_user_exp", referencedColumnName = "token")
    private user _userProjectExp;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBodyAide() {
		return bodyAide;
	}


	public void setBodyAide(String bodyAide) {
		this.bodyAide = bodyAide;
	}


	public String getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}


	public project get_project() {
		return _project;
	}


	public void set_project(project _project) {
		this._project = _project;
	}


	public adminstrateur get_userAdminDest() {
		return _userAdminDest;
	}


	public void set_userAdminDest(adminstrateur _userAdminDest) {
		this._userAdminDest = _userAdminDest;
	}


	public user get_userProjectExp() {
		return _userProjectExp;
	}


	public void set_userProjectExp(user _userProjectExp) {
		this._userProjectExp = _userProjectExp;
	}

	



	
  

}

