package com.api.crowdlending.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.api.crowdlending.enumapp.likeDislikeProject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "list_users_vues_project")
@JsonIgnoreProperties(value = {"date_created"},allowGetters = true)
public class vueProjectModel implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   
    
    @Column(nullable = false)
    private String date_created;
    
    @Column(nullable = true)  
    private String date_update; 
    
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;
    
    @Column(nullable = false)
    private Long timestamp;  
    
    @Column(nullable = false)
    private String date_consultation;  
    
    @Column(nullable = true)
    private String ip_adress;
    
    
    @OneToOne
    @JoinColumn(name = "token_project", referencedColumnName = "token", nullable = false)
    private project _project ;
    
    @OneToOne
    @JoinColumn(name = "token_user", referencedColumnName = "token", nullable = false)
    private user _user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getDate_update() {
		return date_update;
	}

	public void setDate_update(String date_update) {
		this.date_update = date_update;
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

	public user get_user() {
		return _user;
	}

	public void set_user(user _user) {
		this._user = _user;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String formattedDate) {
		this.date_created = formattedDate;
	}

	public String getDate_consultation() {
		return date_consultation;
	}

	public void setDate_consultation(String date_consultation) {
		this.date_consultation = date_consultation;
	}

	public String getIp_adress() {
		return ip_adress;
	}

	public void setIp_adress(String ip_adress) {
		this.ip_adress = ip_adress;
	}

}
