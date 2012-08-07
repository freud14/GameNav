
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the BATIMENT database table.
 * 
 */
@Entity
@Table(name = "BATIMENT")
@DiscriminatorValue("BATIMENT")
public class Batiment extends Technologie implements Serializable {

	private static final long		serialVersionUID	= 1L;

	// bi-directional many-to-one association to PlaneteBatiment
	@OneToMany(mappedBy = "batiment")
	private List<PlaneteBatiment>	planeteBatiment;

	public Batiment() {

	}

	public List<PlaneteBatiment> getPlaneteBatiment() {

		return this.planeteBatiment;
	}

	public void setPlaneteBatiment(List<PlaneteBatiment> planeteBatiment) {

		this.planeteBatiment = planeteBatiment;
	}

}