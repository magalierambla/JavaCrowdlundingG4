package com.api.crowdlending.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.OneToOne;


@Entity
@Table(name = "contact_visitors",uniqueConstraints={@UniqueConstraint(columnNames ={"token"})})
public class contactModel implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String token;
    
	@Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String date_created;
    
    @Column(nullable = false)
    private String sujet;


	@Column(nullable = true)
    private String date_read;
    
    @Column(nullable = false)
    private Long timestamp_created;
    
    @Column(nullable = true)
    private Long timestamp_read;
    
    @ColumnDefault("0")
    private int statut_read;   
 

	@Column(columnDefinition="TEXT",nullable = false)
    private String description;


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDate_created() {
		return date_created;
	}


	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}


	public String getDate_read() {
		return date_read;
	}


	public void setDate_read(String date_read) {
		this.date_read = date_read;
	}


	public Long getTimestamp_created() {
		return timestamp_created;
	}


	public void setTimestamp_created(Long timestamp_created) {
		this.timestamp_created = timestamp_created;
	}


	public Long getTimestamp_read() {
		return timestamp_read;
	}


	public void setTimestamp_read(Long timestamp_read) {
		this.timestamp_read = timestamp_read;
	}


	public int getStatut_read() {
		return statut_read;
	}


	public void setStatut_read(int statut_read) {
		this.statut_read = statut_read;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
    public String getSujet() {
		return sujet;
	}


	public void setSujet(String sujet) {
		this.sujet = sujet;
	}


	@Override
	public String toString() {
		return "contactModel [id=" + id + ", token=" + token + ", email=" + email + ", date_created=" + date_created
				+ ", date_read=" + date_read + ", timestamp_created=" + timestamp_created + ", timestamp_read="
				+ timestamp_read + ", statut_read=" + statut_read + ", description=" + description + "]";
	}

    

}