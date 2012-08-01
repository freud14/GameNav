package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PLANETE_RESSOURCE database table.
 * 
 */
@Embeddable
public class PlaneteRessourcePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="RESSOURCE_ID")
	private int ressourceId;

	@Column(name="PLANETE_ID")
	private int planeteId;

	public PlaneteRessourcePK() {
	}
	public int getRessourceId() {
		return this.ressourceId;
	}
	public void setRessourceId(int ressourceId) {
		this.ressourceId = ressourceId;
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
		if (!(other instanceof PlaneteRessourcePK)) {
			return false;
		}
		PlaneteRessourcePK castOther = (PlaneteRessourcePK)other;
		return 
			(this.ressourceId == castOther.ressourceId)
			&& (this.planeteId == castOther.planeteId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ressourceId;
		hash = hash * prime + this.planeteId;
		
		return hash;
	}
}