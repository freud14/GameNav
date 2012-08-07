
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TRAJET_RESSOURCE database table.
 * 
 */
@Embeddable
public class TrajetRessourcePK implements Serializable {

	// default serial version id, required for serializable classes.
	private static final long	serialVersionUID	= 1L;

	@Column(name = "TRAJET_ID", insertable = false, updatable = false)
	private int					trajetId;

	@Column(name = "RESSOURCE_ID", insertable = false, updatable = false)
	private int					ressourceId;

	public TrajetRessourcePK() {

	}

	public int getTrajetId() {

		return this.trajetId;
	}

	public void setTrajetId(int trajetId) {

		this.trajetId = trajetId;
	}

	public int getRessourceId() {

		return this.ressourceId;
	}

	public void setRessourceId(int ressourceId) {

		this.ressourceId = ressourceId;
	}

	public boolean equals(Object other) {

		if (this == other) {
			return true;
		}
		if (!(other instanceof TrajetRessourcePK)) {
			return false;
		}
		TrajetRessourcePK castOther = (TrajetRessourcePK) other;
		return (this.trajetId == castOther.trajetId)
				&& (this.ressourceId == castOther.ressourceId);
	}

	public int hashCode() {

		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.trajetId;
		hash = hash * prime + this.ressourceId;

		return hash;
	}
}