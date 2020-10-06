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


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.api.crowdlending.enumapp.validProject;


@Entity
@Table(name = "projects", uniqueConstraints = {@UniqueConstraint(columnNames = {"token", "nom"})})
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Project implements Serializable {


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
    private porte_project _porte_project;

    @OneToOne
    @JoinColumn(name = "statut_project", referencedColumnName = "id")
    private statutProject _statut_project;

    @OneToOne
    @JoinColumn(name = "token_user", referencedColumnName = "token")
    private User _user;

    @OneToOne
    @JoinColumn(name = "token_manager", referencedColumnName = "token")
    private Adminstrateur manager_project;

}
