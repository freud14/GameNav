
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PLANETE_BATIMENT database table.
 * 
 */
@Embeddable
public class PlaneteBatimentPK implements Serializable {

	// default serial version id, required for serializable classes.
	private static final long	serialVersionUID	= 1L;

	@Column(name = "BATIMENT_ID", insertable = false, updatable = false)
	private int					batimentId;

	@Column(name = "PLANETE_ID", insertable = false, updatable = false)
	private int					planeteId;

	public PlaneteBatimentPK() {

	}

	public int getBatimentId() {

		return this.batimentId;
	}

	public void setBatimentId(int batimentId) {

		this.batimentId = batimentId;
	}

	public int getPlaneteId() {

		return this.planeteId;
	}

	public void setPlaneteId(int planeteId) {

		this.planeteId = planeteId;
	}

	public boolean equals(Object other) {

		if (this == other) {
			return true;
		}
		if (!(other instanceof PlaneteBatimentPK)) {
			return false;
		}
		PlaneteBatimentPK castOther = (PlaneteBatimentPK) other;
		return (this.batimentId == castOther.batimentId)
				&& (this.planeteId == castOther.planeteId);
	}

	public int hashCode() {

		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.batimentId;
		hash = hash * prime + this.planeteId;

		return hash;
	}
}