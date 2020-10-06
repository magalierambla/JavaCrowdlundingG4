package com.api.crowdlending.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.OneToOne;


@Entity
@Table(name = "favoris_project_user",uniqueConstraints={@UniqueConstraint(columnNames ={"token"})})
public class favorisProjectUserModel implements Serializable{



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String date_created;

    @Column(nullable = false)
    private Long timestamp;

    @Column(nullable = false)
    private String token;

    @OneToOne
    @JoinColumn(name = "token_project", referencedColumnName = "token")
    private Project _project ;

    @OneToOne
    @JoinColumn(name = "token_user", referencedColumnName = "token")
    private User _user;

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Project get_project() {
		return _project;
	}

	public void set_project(Project _project) {
		this._project = _project;
	}

	public User get_user() {
		return _user;
	}

	public void set_user(User _user) {
		this._user = _user;
	}









}

