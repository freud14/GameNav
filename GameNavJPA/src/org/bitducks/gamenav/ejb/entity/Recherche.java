package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the RECHERCHE database table.
 * 
 */
@Entity
@Table(name = "RECHERCHE")
@DiscriminatorValue("RECHERCHE")
public class Recherche extends Technologie implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to RechercheJoueur
	@OneToMany(mappedBy = "recherche")
	private List<RechercheJoueur> rechercheJoueur;

	public Recherche() {
	}

	public List<RechercheJoueur> getRechercheJoueur() {
		return this.rechercheJoueur;
	}

	public void setRechercheJoueur(List<RechercheJoueur> rechercheJoueur) {
		this.rechercheJoueur = rechercheJoueur;
	}

}