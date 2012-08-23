
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the JOUEUR_UNIVERS database table.
 * 
 */
@Entity
@Table(name = "JOUEUR_UNIVERS")
public class JoueurUnivers implements Serializable {

	private static final long			serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int							id;

	// bi-directional many-to-one association to GrpeVaisseauJoueur
	@OneToMany(mappedBy = "joueurUnivers")
	private List<GrpeVaisseauJoueur>	grpeVaisseauJoueur;

	// bi-directional many-to-one association to Joueur
	@ManyToOne
	@JoinColumn(name = "JOUEUR_ID", insertable = false, updatable = false)
	private Joueur						joueur;

	// bi-directional many-to-one association to Univers
	@ManyToOne
	@JoinColumn(name = "UNIVERS_ID", insertable = false, updatable = false)
	private Univers						univers;

	@Column(name = "JOUEUR_ID")
	private int							joueurId;

	@Column(name = "UNIVERS_ID")
	private int							universId;

	// bi-directional many-to-one association to Planete
	@OneToMany(mappedBy = "joueurUnivers")
	private List<Planete>				planete;

	// bi-directional many-to-one association to RechercheJoueur
	@OneToMany(mappedBy = "joueurUnivers")
	private List<RechercheJoueur>		rechercheJoueur;

	public JoueurUnivers() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public List<GrpeVaisseauJoueur> getGrpeVaisseauJoueur() {

		return this.grpeVaisseauJoueur;
	}

	public void setGrpeVaisseauJoueur(
			List<GrpeVaisseauJoueur> grpeVaisseauJoueur) {

		this.grpeVaisseauJoueur = grpeVaisseauJoueur;
	}

	public Joueur getJoueur() {

		return this.joueur;
	}

	public Univers getUnivers() {

		return this.univers;
	}

	public int getJoueurId() {

		return this.joueurId;
	}

	public void setJoueurId(int joueurId) {

		this.joueurId = joueurId;
	}

	public int getUniversId() {

		return this.universId;
	}

	public void setUniversId(int universId) {

		this.universId = universId;
	}

	public List<Planete> getPlanete() {

		return this.planete;
	}

	public void setPlanete(List<Planete> planete) {

		this.planete = planete;
	}

	public List<RechercheJoueur> getRechercheJoueur() {

		return this.rechercheJoueur;
	}

	public void setRechercheJoueur(List<RechercheJoueur> rechercheJoueur) {

		this.rechercheJoueur = rechercheJoueur;
	}

}