
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
@Table(name = "UNIVERS")
public class Univers implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int					id;

	@Column(name = "NOM")
	private String				nom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATION")
	private Date				dateCreation;

	@Lob
	@Column(name = "DESCRIPTION")
	private String				description;

	@Column(name = "NB_EMPLACEMENT_SYSTEME_SOLAIRE")
	private int					nbEmplacementSystemeSolaire;

	@Column(name = "NB_GALAXIE")
	private int					nbGalaxie;

	@Column(name = "NB_SYSTEME_SOLAIRE_GALAXIE")
	private int					nbSystemeSolaireGalaxie;

	@Column(name = "LAST_EMPLACEMENT")
	private int					lastEmplacement;

	@Column(name = "LAST_GALAXIE")
	private int					lastGalaxie;

	@Column(name = "LAST_SYSTEME_SOLAIRE")
	private int					lastSystemeSolaire;

	@Column(name = "NB_EMPLACEMENT_JOUEUR")
	private int					nbEmplacementJoueur;

	// bi-directional many-to-one association to JoueurUnivers
	@OneToMany(mappedBy = "univers")
	private List<JoueurUnivers>	joueurUnivers;

	public Univers() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getNom() {

		return this.nom;
	}

	public void setNom(String nom) {

		this.nom = nom;
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

	public int getLastEmplacement() {

		return this.lastEmplacement;
	}

	public void setLastEmplacement(int lastEmplacement) {

		this.lastEmplacement = lastEmplacement;
	}

	public int getLastGalaxie() {

		return this.lastGalaxie;
	}

	public void setLastGalaxie(int lastGalaxie) {

		this.lastGalaxie = lastGalaxie;
	}

	public int getLastSystemeSolaire() {

		return this.lastSystemeSolaire;
	}

	public void setLastSystemeSolaire(int lastSystemeSolaire) {

		this.lastSystemeSolaire = lastSystemeSolaire;
	}

	public int getNbEmplacementJoueur() {

		return this.nbEmplacementJoueur;
	}

	public void setNbEmplacementJoueur(int nbEmplacementJoueur) {

		this.nbEmplacementJoueur = nbEmplacementJoueur;
	}

	public List<JoueurUnivers> getJoueurUnivers() {

		return this.joueurUnivers;
	}

	public void setJoueurUnivers(List<JoueurUnivers> joueurUnivers) {

		this.joueurUnivers = joueurUnivers;
	}

	@Override
	public String toString() {

		return "Univers2 [id=" + this.id + ", dateCreation="
				+ this.dateCreation + ", description=" + this.description
				+ ", nbEmplacementSystemeSolaire="
				+ this.nbEmplacementSystemeSolaire + ", nbGalaxie="
				+ this.nbGalaxie + ", nbSystemeSolaireGalaxie="
				+ this.nbSystemeSolaireGalaxie + ", nom=" + this.nom
				+ ", joueurUnivers=" + this.joueurUnivers
				+ ", lastEmplacement=" + this.lastEmplacement
				+ ", lastGalaxie=" + this.lastGalaxie + ", lastSystemeSolaire="
				+ this.lastSystemeSolaire + "]";
	}

}