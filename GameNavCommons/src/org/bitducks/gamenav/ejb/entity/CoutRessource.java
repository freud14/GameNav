
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COUT_RESSOURCE database table.
 * 
 */
@Entity
@Table(name = "COUT_RESSOURCE")
public class CoutRessource implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@EmbeddedId
	private CoutRessourcePK		id;

	@Column(name = "COUT_BASE")
	private int					coutBase;

	@Column(name = "MULTIPLICATEUR")
	private int					multiplicateur;

	// bi-directional many-to-one association to Ressource
	@ManyToOne
	@JoinColumn(name = "RESSOURCE_ID")
	private Ressource			ressource;

	// bi-directional many-to-one association to Technologie
	@ManyToOne
	@JoinColumn(name = "TECHNOLOGIE_ID")
	private Technologie			technologie;

	public CoutRessource() {

	}

	public CoutRessourcePK getId() {

		return this.id;
	}

	public void setId(CoutRessourcePK id) {

		this.id = id;
	}

	public int getCoutBase() {

		return this.coutBase;
	}

	public void setCoutBase(int coutBase) {

		this.coutBase = coutBase;
	}

	public int getMultiplicateur() {

		return this.multiplicateur;
	}

	public void setMultiplicateur(int multiplicateur) {

		this.multiplicateur = multiplicateur;
	}

	public Ressource getRessource() {

		return this.ressource;
	}

	public void setRessource(Ressource ressource) {

		this.ressource = ressource;
	}

	public Technologie getTechnologie() {

		return this.technologie;
	}

	public void setTechnologie(Technologie technologie) {

		this.technologie = technologie;
	}

}