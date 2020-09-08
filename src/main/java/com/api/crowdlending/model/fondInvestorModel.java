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
import javax.validation.constraints.NotBlank;
import javax.persistence.OneToOne;


@Entity
@Table(name = "fonds_investisseurs_paypal",uniqueConstraints={@UniqueConstraint(columnNames ={"token"})})
public class fondInvestorModel implements Serializable{
	
    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long amount;
    
    @Column(nullable = false)
    private String token;   
  

	@Column(nullable = false)
    private String dateCreated;
    
    @Column(nullable = false)
    private Long timestamp;
    
    @OneToOne
    @JoinColumn(name = "token_investisseur_project", referencedColumnName = "token")
    private investisseursProjectModel _investisseurProject ;
    
    @OneToOne
    @JoinColumn(name = "token_user", referencedColumnName = "token")
    private user _user;
    
    @OneToOne
    @JoinColumn(name = "token_project", referencedColumnName = "token")
    private project _project ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getToken() {
			return token;
	}

	public void setToken(String token) {
			this.token = token;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
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

	public investisseursProjectModel get_investisseurProject() {
		return _investisseurProject;
	}

	public void set_investisseurProject(investisseursProjectModel _investisseursProject) {
		this._investisseurProject = _investisseursProject;
	}

	public user get_user() {
		return _user;
	}

	public void set_user(user _user) {
		this._user = _user;
	}

	public project get_project() {
		return _project;
	}

	public void set_project(project _project) {
		this._project = _project;
	}

	@Override
	public String toString() {
		return "fondInvestorModel [id=" + id + ", amount=" + amount + ", token=" + token + ", dateCreated="
				+ dateCreated + ", timestamp=" + timestamp + ", _investisseurProject=" + _investisseurProject.toString()
				+ ", _user=" + _user + ", _project=" + _project + "]";
	}   



	
  

}
