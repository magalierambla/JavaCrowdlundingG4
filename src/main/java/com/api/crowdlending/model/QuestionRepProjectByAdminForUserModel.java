package com.api.crowdlending.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToOne;


@Entity
@Table(name = "question_rep_project_by_admin_for_user")
public class QuestionRepProjectByAdminForUserModel implements Serializable{



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
    private Project _project ;

    @OneToOne
    @JoinColumn(name = "token_admin_exp", referencedColumnName = "token")
    private Adminstrateur _userAdminExp;

	@OneToOne
    @JoinColumn(name = "token_user_dest", referencedColumnName = "token")
    private User _userProjectDest;

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

	public Project get_project() {
		return _project;
	}

	public void set_project(Project _project) {
		this._project = _project;
	}

	public Adminstrateur get_userAdminExp() {
		return _userAdminExp;
	}

	public void set_userAdminExp(Adminstrateur _userAdminExp) {
		this._userAdminExp = _userAdminExp;
	}

	public User get_userProjectDest() {
		return _userProjectDest;
	}

	public void set_userProjectDest(User _userProjectDest) {
		this._userProjectDest = _userProjectDest;
	}




}
