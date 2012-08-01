package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the UNIVERS database table.
 * 
 */
@Entity
@Table(name="UNIVERS")
public class Univers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_CREATION")
	private Date dateCreation;

	@Lob
	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="NB_EMPLACEMENT_SYSTEME_SOLAIRE")
	private int nbEmplacementSystemeSolaire;

	@Column(name="NB_GALAXIE")
	private int nbGalaxie;

	@Column(name="NB_SYSTEME_SOLAIRE_GALAXIE")
	private int nbSystemeSolaireGalaxie;

	@Column(name="NOM")
	private String nom;

	//bi-directional many-to-one association to JoueurUnivers
	@OneToMany(mappedBy="univers")
	private List<JoueurUnivers> joueurUnivers;

	public Univers() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbEmplacementSystemeSolaire() {
		return this.nbEmplacementSystemeSolaire;
	}

	public void setNbEmplacementSystemeSolaire(int nbEmplacementSystemeSolaire) {
		this.nbEmplacementSystemeSolaire = nbEmplacementSystemeSolaire;
	}

	public int getNbGalaxie() {
		return this.nbGalaxie;
	}

	public void setNbGalaxie(int nbGalaxie) {
		this.nbGalaxie = nbGalaxie;
	}

	public int getNbSystemeSolaireGalaxie() {
		return this.nbSystemeSolaireGalaxie;
	}

	public void setNbSystemeSolaireGalaxie(int nbSystemeSolaireGalaxie) {
		this.nbSystemeSolaireGalaxie = nbSystemeSolaireGalaxie;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<JoueurUnivers> getJoueurUnivers() {
		return this.joueurUnivers;
	}

	public void setJoueurUnivers(List<JoueurUnivers> joueurUnivers) {
		this.joueurUnivers = joueurUnivers;
	}

}