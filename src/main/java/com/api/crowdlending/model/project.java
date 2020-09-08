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
import javax.persistence.UniqueConstraint;


import org.hibernate.annotations.ColumnDefault;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.api.crowdlending.enumapp.validProject;



@Entity
@Table(name = "projects",uniqueConstraints={@UniqueConstraint(columnNames ={"token","nom"})})
@EntityListeners(AuditingEntityListener.class)
public class project  implements Serializable{
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date created_at;

	    @Column(nullable = true)
	    private String nom;
	    
	    @Column(nullable = false)
	    private String description;
	    
	    @Column(nullable = false)
	    private Long montant_minimun;
	    
	    @Column(nullable = true)
	    @Temporal(TemporalType.DATE)   
	    @CreatedDate     
	    private Date date_limite_collecte;
	    
	    @Column(nullable = false)
	    private String contrePartieProject;	    
	    
	    @Column(nullable = false)
	    private String afficheProject;
	    
	    @Enumerated(EnumType.STRING)  
	    private validProject valid_project;
	    
	    @Column(nullable = false)
	    private String token;
	    
	    @ColumnDefault("0")
	    private int total_fonds;
	    
	    @ColumnDefault("0")
	    private int total_hearts;
	    
	    @ColumnDefault("0")
	    private int total_like;
	    
	    @ColumnDefault("0")
	    private int total_dislike;
	    
	    @ColumnDefault("0")
	    private int total_vues;
	    
	

	    @OneToOne
        @JoinColumn(name = "id_category", referencedColumnName = "id")
        private category_project categoryProject;
		
		
	  
	    
	    
	    

	    @OneToOne
        @JoinColumn(name = "porte_project_id", referencedColumnName = "id")
        private porte_project  _porte_project ;
	    
	    @OneToOne
        @JoinColumn(name = "statut_project", referencedColumnName = "id")
        private statutProject _statut_project ;
	    
	    @OneToOne
        @JoinColumn(name = "token_user", referencedColumnName = "token")
        private user _user;
	    
	    
	 
	    @OneToOne
        @JoinColumn(name = "token_manager", referencedColumnName = "token")
        private adminstrateur manager_project ;
	    

	    
	    
	    

		public adminstrateur getManager_project() {
			return manager_project;
		}

		public void setManager_project(adminstrateur manager_project) {
			this.manager_project = manager_project;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getMontant_minimun() {
			return montant_minimun;
		}

		public void setMontant_minimun(Long montant_minimun) {
			this.montant_minimun = montant_minimun;
		}

		public Date getDate_limite_collecte() {
			return date_limite_collecte;
		}

		public void setDate_limite_collecte(Date date_limite_collecte) {
			this.date_limite_collecte = date_limite_collecte;
		}

		public String getContrePartieProject() {
			return contrePartieProject;
		}

		public void setContrePartieProject(String contrePartieProject) {
			this.contrePartieProject = contrePartieProject;
		}

		public String getAfficheProject() {
			return afficheProject;
		}

		public void setAfficheProject(String afficheProject) {
			this.afficheProject = afficheProject;
		}

		public validProject getValid_project() {
			return valid_project;
		}

		public void setValid_project(validProject valid_project) {
			this.valid_project = valid_project;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public category_project getCategoryProject() {
			return categoryProject;
		}

		public void setCategoryProject(category_project categoryProject) {
			this.categoryProject = categoryProject;
		}

		public porte_project get_porte_project() {
			return _porte_project;
		}

		public void set_porte_project(porte_project porte_project) {
			this._porte_project = porte_project;
		}

		public statutProject get_statut_project() {
			return _statut_project;
		}

		public void set_statut_project(statutProject _statut_project) {
			this._statut_project = _statut_project;
		}

		public user get_user() {
			return _user;
		}

		public void set_user(user _user) {
			this._user = _user;
		}

		public int getTotal_fonds() {
			return total_fonds;
		}

		public void setTotal_fonds(int totalFonds) {
			this.total_fonds = totalFonds;
		}
		
	    public int getTotal_hearts() {
				return total_hearts;
		}

		public void setTotal_hearts(int total_hearts) {
				this.total_hearts = total_hearts;
		}
	

		public int getTotal_like() {
			return total_like;
		}

		public void setTotal_like(int total_like) {
			this.total_like = total_like;
		}

		public int getTotal_dislike() {
			return total_dislike;
		}

		public void setTotal_dislike(int total_dislike) {
			this.total_dislike = total_dislike;
		}

		public int getTotal_vues() {
			return total_vues;
		}

		public void setTotal_vues(int total_vues) {
			this.total_vues = total_vues;
		}

		public Date getCreated_at() {
			return created_at;
		}

		public void setCreated_at(Date created_at) {
			this.created_at = created_at;
		}

	/*	public adminstrateur getManager_project() {
			return manager_project;
		}

		public void setManager_project(adminstrateur manager_project) {
			this.manager_project = manager_project;
		}*/

	/*    @Override
		public String toString() {
			return "project [id=" + id + ", nom=" + nom + ", description=" + description + ", montant_minimun="
					+ montant_minimun + ", date_limite_collecte=" + date_limite_collecte + ", contrePartieProject="
					+ contrePartieProject + ", afficheProject=" + afficheProject + ", valid_project=" + valid_project
					+ ", token=" + token + ", categoryProject=" + categoryProject + ", porteProject=" + _porteProject
					+ ", _statut_project=" + _statut_project + ", _user=" + _user + ", manager_project="
					+ manager_project + "]";
		}	*/
	   
	  /*  public adressReseauxSociauxProject get_adressReseauxSociauxProject() {
			return _adressReseauxSociauxProject;
		}

		public void set_adressReseauxSociauxProject(adressReseauxSociauxProject _adressReseauxSociauxProject) {
			this._adressReseauxSociauxProject = _adressReseauxSociauxProject;
			
		}*/
	    
        
	     
	
	  

}
