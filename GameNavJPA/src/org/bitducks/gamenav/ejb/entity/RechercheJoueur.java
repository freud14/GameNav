package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RECHERCHE_JOUEUR database table.
 * 
 */
@Entity
@Table(name="RECHERCHE_JOUEUR")
public class RechercheJoueur implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RechercheJoueurPK id;

	@Column(name="NIVEAU")
	private int niveau;

	//bi-directional many-to-one association to Joueur
	@ManyToOne
	@JoinColumn(name="JOUEUR_UNIVERS_ID")
	private Joueur joueur;

	//bi-directional many-to-one association to JoueurUnivers
	@ManyToOne
	@JoinColumn(name="JOUEUR_UNIVERS_ID")
	private JoueurUnivers joueurUnivers;

	//bi-directional many-to-one association to Recherche
	@ManyToOne
	@JoinColumn(name="RECHERCHE_ID")
	private Recherche recherche;

	public RechercheJoueur() {
	}

	public RechercheJoueurPK getId() {
		return this.id;
	}

	public void setId(RechercheJoueurPK id) {
		this.id = id;
	}

	public int getNiveau() {
		return this.niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public JoueurUnivers getJoueurUnivers() {
		return this.joueurUnivers;
	}

	public void setJoueurUnivers(JoueurUnivers joueurUnivers) {
		this.joueurUnivers = joueurUnivers;
	}

	public Recherche getRecherche() {
		return this.recherche;
	}

	public void setRecherche(Recherche recherche) {
		this.recherche = recherche;
	}

}