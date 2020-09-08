package com.api.crowdlending.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;

import com.api.crowdlending.enumapp.statutDemandeInvest;


@Entity
@Table(name = "investisseurs_project",uniqueConstraints={@UniqueConstraint(columnNames ={"token"})})
public class investisseursProjectModel implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
	 @Column(nullable = false, updatable = false)	 
	 private String date_created;
   
    @Column(nullable = false)
    private String token;
    
    @Column(nullable = false)
    private Long timestamp;
    
    @Enumerated(EnumType.STRING)  
    private  statutDemandeInvest  statutDemande ;
    
    @OneToOne
    @JoinColumn(name = "token_project", referencedColumnName = "token")
    private project _project ;
    
    @OneToOne
    @JoinColumn(name = "token_invest", referencedColumnName = "token")
    private user _userProjectInvest;
    
    @Column(nullable = true)  
    private String date_update;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public statutDemandeInvest getStatutDemande() {
		return statutDemande;
	}

	public void setStatutDemande(statutDemandeInvest statutDemande) {
		this.statutDemande = statutDemande;
	}

	public project get_project() {
		return _project;
	}

	public void set_project(project _project) {
		this._project = _project;
	}

	public user get_userProjectInvest() {
		return _userProjectInvest;
	}

	public void set_userProjectInvest(user _userProjectInvest) {
		this._userProjectInvest = _userProjectInvest;
	}

	public String getDate_update() {
		return date_update;
	}

	public void setDate_update(String date_update) {
		this.date_update = date_update;
	}

	@Override
	public String toString() {
		return "investisseursProjectModel [id=" + id + ", date_created=" + date_created + ", token=" + token
				+ ", timestamp=" + timestamp + ", statutDemande=" + statutDemande + ", _project=" + _project
				+ ", _userProjectInvest=" + _userProjectInvest + ", date_update=" + date_update + "]";
	} 
    
	

}
