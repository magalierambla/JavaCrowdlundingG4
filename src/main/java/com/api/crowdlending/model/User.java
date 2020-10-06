package com.api.crowdlending.model;

import com.api.crowdlending.enumapp.sexUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class User implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String pseudo;

	@Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private sexUser sexe;

    @Column(nullable = false)
    private String typeCompte;

	private String photo;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

	@Column(nullable = false)
    private String token;
	private String profile;
}
