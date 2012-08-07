
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
	@JoinColumn(name = "JOUEUR_ID")
	private Joueur						joueur;

	// bi-directional many-to-one association to Univers
	@ManyToOne
	@JoinColumn(name = "UNIVERS_ID")
	private Univers						univers;

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

	public void setJoueur(Joueur joueur) {

		this.joueur = joueur;
	}

	public Univers getUnivers() {

		return this.univers;
	}

	public void setUnivers(Univers univers) {

		this.univers = univers;
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