
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PLANETE_BATIMENT database table.
 * 
 */
@Entity
@Table(name = "PLANETE_BATIMENT")
public class PlaneteBatiment implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@EmbeddedId
	private PlaneteBatimentPK	id;

	@Column(name = "NIVEAU")
	private int					niveau;

	// bi-directional many-to-one association to Batiment
	@ManyToOne
	@JoinColumn(name = "BATIMENT_ID")
	private Batiment			batiment;

	// bi-directional many-to-one association to Planete
	@ManyToOne
	@JoinColumn(name = "PLANETE_ID")
	private Planete				planete;

	public PlaneteBatiment() {

	}

	public PlaneteBatimentPK getId() {

		return this.id;
	}

	public void setId(PlaneteBatimentPK id) {

		this.id = id;
	}

	public int getNiveau() {

		return this.niveau;
	}

	public void setNiveau(int niveau) {

		this.niveau = niveau;
	}

	public Batiment getBatiment() {

		return this.batiment;
	}

	public void setBatiment(Batiment batiment) {

		this.batiment = batiment;
	}

	public Planete getPlanete() {

		return this.planete;
	}

	public void setPlanete(Planete planete) {

		this.planete = planete;
	}

}