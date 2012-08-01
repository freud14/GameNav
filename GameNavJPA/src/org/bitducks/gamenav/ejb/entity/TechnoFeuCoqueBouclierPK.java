package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TECHNO_FEU_COQUE_BOUCLIER database table.
 * 
 */
@Embeddable
public class TechnoFeuCoqueBouclierPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TECHNOLOGIE_ID")
	private int technologieId;

	@Column(name="VAISSEAU_DEFENSE")
	private int vaisseauDefense;

	public TechnoFeuCoqueBouclierPK() {
	}
	public int getTechnologieId() {
		return this.technologieId;
	}
	public void setTechnologieId(int technologieId) {
		this.technologieId = technologieId;
	}
	public int getVaisseauDefense() {
		return this.vaisseauDefense;
	}
	public void setVaisseauDefense(int vaisseauDefense) {
		this.vaisseauDefense = vaisseauDefense;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TechnoFeuCoqueBouclierPK)) {
			return false;
		}
		TechnoFeuCoqueBouclierPK castOther = (TechnoFeuCoqueBouclierPK)other;
		return 
			(this.technologieId == castOther.technologieId)
			&& (this.vaisseauDefense == castOther.vaisseauDefense);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.technologieId;
		hash = hash * prime + this.vaisseauDefense;
		
		return hash;
	}
}