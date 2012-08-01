package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PREREQUIS database table.
 * 
 */
@Embeddable
public class PrerequisPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TECHNOLOGIE_ID")
	private int technologieId;

	@Column(name="TECH_PREREQUIS")
	private int techPrerequis;

	public PrerequisPK() {
	}
	public int getTechnologieId() {
		return this.technologieId;
	}
	public void setTechnologieId(int technologieId) {
		this.technologieId = technologieId;
	}
	public int getTechPrerequis() {
		return this.techPrerequis;
	}
	public void setTechPrerequis(int techPrerequis) {
		this.techPrerequis = techPrerequis;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrerequisPK)) {
			return false;
		}
		PrerequisPK castOther = (PrerequisPK)other;
		return 
			(this.technologieId == castOther.technologieId)
			&& (this.techPrerequis == castOther.techPrerequis);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.technologieId;
		hash = hash * prime + this.techPrerequis;
		
		return hash;
	}
}