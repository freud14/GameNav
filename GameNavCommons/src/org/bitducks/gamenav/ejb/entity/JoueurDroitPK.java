
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the JOUEUR_DROIT database table.
 * 
 */
@Embeddable
public class JoueurDroitPK implements Serializable {

	// default serial version id, required for serializable classes.
	private static final long	serialVersionUID	= 1L;

	@Column(name = "LOGIN")
	private String				login;

	@Column(name = "DROIT")
	private String				droit;

	public JoueurDroitPK(String login, String droit) {

		super();
		this.login = login;
		this.droit = droit;
	}

	public JoueurDroitPK() {

	}

	public String getLogin() {

		return this.login;
	}

	public void setLogin(String login) {

		this.login = login;
	}

	public String getDroit() {

		return this.droit;
	}

	public void setDroit(String droit) {

		this.droit = droit;
	}

	public boolean equals(Object other) {

		if (this == other) {
			return true;
		}
		if (!(other instanceof JoueurDroitPK)) {
			return false;
		}
		JoueurDroitPK castOther = (JoueurDroitPK) other;
		return this.login.equals(castOther.login)
				&& this.droit.equals(castOther.droit);
	}

	public int hashCode() {

		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.login.hashCode();
		hash = hash * prime + this.droit.hashCode();

		return hash;
	}
}