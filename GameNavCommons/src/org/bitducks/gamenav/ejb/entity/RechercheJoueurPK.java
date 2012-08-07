
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RECHERCHE_JOUEUR database table.
 * 
 */
@Embeddable
public class RechercheJoueurPK implements Serializable {

	// default serial version id, required for serializable classes.
	private static final long	serialVersionUID	= 1L;

	@Column(name = "RECHERCHE_ID", insertable = false, updatable = false)
	private int					rechercheId;

	@Column(name = "JOUEUR_UNIVERS_ID", insertable = false, updatable = false)
	private int					joueurUniversId;

	public RechercheJoueurPK() {

	}

	public int getRechercheId() {

		return this.rechercheId;
	}

	public void setRechercheId(int rechercheId) {

		this.rechercheId = rechercheId;
	}

	public int getJoueurUniversId() {

		return this.joueurUniversId;
	}

	public void setJoueurUniversId(int joueurUniversId) {

		this.joueurUniversId = joueurUniversId;
	}

	public boolean equals(Object other) {

		if (this == other) {
			return true;
		}
		if (!(other instanceof RechercheJoueurPK)) {
			return false;
		}
		RechercheJoueurPK castOther = (RechercheJoueurPK) other;
		return (this.rechercheId == castOther.rechercheId)
				&& (this.joueurUniversId == castOther.joueurUniversId);
	}

	public int hashCode() {

		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.rechercheId;
		hash = hash * prime + this.joueurUniversId;

		return hash;
	}
}