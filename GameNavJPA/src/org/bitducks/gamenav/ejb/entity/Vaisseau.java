package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the VAISSEAU database table.
 * 
 */
@Entity
@Table(name = "VAISSEAU")
@DiscriminatorValue("VAISSEAU")
public class Vaisseau extends Technologie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "BOUCLIER")
	private int bouclier;

	@Column(name = "COQUE")
	private int coque;

	@Column(name = "FEU")
	private int feu;

	// bi-directional many-to-one association to GrpeVaisseauJoueur
	@OneToMany(mappedBy = "vaisseau")
	private List<GrpeVaisseauJoueur> grpeVaisseauJoueur;

	public Vaisseau() {
	}

	public int getBouclier() {
		return this.bouclier;
	}

	public void setBouclier(int bouclier) {
		this.bouclier = bouclier;
	}

	public int getCoque() {
		return this.coque;
	}

	public void setCoque(int coque) {
		this.coque = coque;
	}

	public int getFeu() {
		return this.feu;
	}

	public void setFeu(int feu) {
		this.feu = feu;
	}

	public List<GrpeVaisseauJoueur> getGrpeVaisseauJoueur() {
		return this.grpeVaisseauJoueur;
	}

	public void setGrpeVaisseauJoueur(List<GrpeVaisseauJoueur> grpeVaisseauJoueur) {
		this.grpeVaisseauJoueur = grpeVaisseauJoueur;
	}
}