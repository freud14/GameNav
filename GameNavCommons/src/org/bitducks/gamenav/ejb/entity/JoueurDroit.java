
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOUEUR_DROIT database table.
 * 
 */
@Entity
@Table(name = "JOUEUR_DROIT")
public class JoueurDroit implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@EmbeddedId
	private JoueurDroitPK		id;

	public JoueurDroit() {

	}

	public JoueurDroitPK getId() {

		return this.id;
	}

	public void setId(JoueurDroitPK id) {

		this.id = id;
	}

}