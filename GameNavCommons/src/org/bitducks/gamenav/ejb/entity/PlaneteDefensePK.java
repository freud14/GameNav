
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PLANETE_DEFENSE database table.
 * 
 */
@Embeddable
public class PlaneteDefensePK implements Serializable {

	// default serial version id, required for serializable classes.
	private static final long	serialVersionUID	= 1L;

	@Column(name = "DEFENSE_ID", insertable = false, updatable = false)
	private int					defenseId;

	@Column(name = "PLANETE_ID", insertable = false, updatable = false)
	private int					planeteId;

	public PlaneteDefensePK() {

	}

	public int getDefenseId() {

		return this.defenseId;
	}

	public void setDefenseId(int defenseId) {

		this.defenseId = defenseId;
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
		if (!(other instanceof PlaneteDefensePK)) {
			return false;
		}
		PlaneteDefensePK castOther = (PlaneteDefensePK) other;
		return (this.defenseId == castOther.defenseId)
				&& (this.planeteId == castOther.planeteId);
	}

	public int hashCode() {

		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.defenseId;
		hash = hash * prime + this.planeteId;

		return hash;
	}
}