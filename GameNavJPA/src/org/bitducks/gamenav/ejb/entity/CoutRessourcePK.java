package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COUT_RESSOURCE database table.
 * 
 */
@Embeddable
public class CoutRessourcePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TECHNOLOGIE_ID")
	private int technologieId;

	@Column(name="RESSOURCE_ID")
	private int ressourceId;

	public CoutRessourcePK() {
	}
	public int getTechnologieId() {
		return this.technologieId;
	}
	public void setTechnologieId(int technologieId) {
		this.technologieId = technologieId;
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
		if (!(other instanceof CoutRessourcePK)) {
			return false;
		}
		CoutRessourcePK castOther = (CoutRessourcePK)other;
		return 
			(this.technologieId == castOther.technologieId)
			&& (this.ressourceId == castOther.ressourceId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.technologieId;
		hash = hash * prime + this.ressourceId;
		
		return hash;
	}
}