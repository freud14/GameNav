package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TECHNO_RESSOURCE database table.
 * 
 */
@Entity
@Table(name="TECHNO_RESSOURCE")
public class TechnoRessource implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TechnoRessourcePK id;

	@Column(name="MULTIPLICATEUR_PRODUCTION")
	private int multiplicateurProduction;

	//bi-directional many-to-one association to Ressource
	@ManyToOne
	@JoinColumn(name="RESSOURCE_ID")
	private Ressource ressource;

	//bi-directional many-to-one association to Technologie
	@ManyToOne
	@JoinColumn(name="TECHNOLOGIE_ID")
	private Technologie technologie;

	public TechnoRessource() {
	}

	public TechnoRessourcePK getId() {
		return this.id;
	}

	public void setId(TechnoRessourcePK id) {
		this.id = id;
	}

	public int getMultiplicateurProduction() {
		return this.multiplicateurProduction;
	}

	public void setMultiplicateurProduction(int multiplicateurProduction) {
		this.multiplicateurProduction = multiplicateurProduction;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public Technologie getTechnologie() {
		return this.technologie;
	}

	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}

}