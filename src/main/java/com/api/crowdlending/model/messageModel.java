package com.api.crowdlending.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "messagerie_interne")  
@EntityListeners(AuditingEntityListener.class)
public class  messageModel implements Serializable{    

	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private String bodyMessage;
    
    @Column(nullable = false)
    private String dateCreated;
    
    @Column(nullable = false)
    private Long timestamp;
    

    @Column(nullable = true)
    private String _tokenProject ;
    
    @Column(nullable = false)
    private String _nomUserExp;   
    

    @Column(nullable = false)
    private String _nomUserDest;
    
    @Column(nullable = false)
    private String _photoUserExp;   
    

    @Column(nullable = false)
    private String _photoUserDest;
    
    @Column(nullable = false)
    private String _tokenUserExp;   
    

    @Column(nullable = false)
    private String _tokenUserDest;
	
	@Column(nullable = false)
    private String statutExp;
	
	@Column(nullable = false)
    private String statutDest;
	
    @Column(nullable = true)
	 private Long timestampConsultation;
	 
    @Column(nullable = true)
	 private String dateConsultation;

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

	public String getBodyMessage() {
		return bodyMessage;
	}

	public void setBodyMessage(String bodyMessage) {
		this.bodyMessage = bodyMessage;
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

	public String get_tokenProject() {
		return _tokenProject;
	}

	public void set_tokenProject(String _tokenProject) {
		this._tokenProject = _tokenProject;
	}

	public String get_nomUserExp() {
		return _nomUserExp;
	}

	public void set_nomUserExp(String nomUserExp) {
		this._nomUserExp = nomUserExp;
	}

	public String get_nomUserDest() {
		return _nomUserDest;
	}

	public void set_nomUserDest(String _nomUserDest) {
		this._nomUserDest = _nomUserDest;
	}

	public String get_tokenUserExp() {
		return _tokenUserExp;
	}

	public void set_tokenUserExp(String _tokenUserExp) {
		this._tokenUserExp = _tokenUserExp;
	}

	public String get_tokenUserDest() {
		return _tokenUserDest;
	}

	public void set_tokenUserDest(String _tokenUserDest) {
		this._tokenUserDest = _tokenUserDest;
	}

	public String getStatutExp() {
		return statutExp;
	}

	public void setStatutExp(String statutExp) {
		this.statutExp = statutExp;
	}

	public String getStatutDest() {
		return statutDest;
	}

	public void setStatutDest(String statutDest) {
		this.statutDest = statutDest;
	}

	public Long getTimestampConsultation() {
		return timestampConsultation;
	}

	public void setTimestampConsultation(Long timestampConsultation) {
		this.timestampConsultation = timestampConsultation;
	}

	public String getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(String dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public String get_photoUserExp() {
		return _photoUserExp;
	}

	public void set_photoUserExp(String _photoUserExp) {
		this._photoUserExp = _photoUserExp;
	}

	public String get_photoUserDest() {
		return _photoUserDest;
	}

	public void set_photoUserDest(String _photoUserDest) {
		this._photoUserDest = _photoUserDest;
	}
	
   


	



	
  

}
