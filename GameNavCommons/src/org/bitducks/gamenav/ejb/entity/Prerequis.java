
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PREREQUIS database table.
 * 
 */
@Entity
@Table(name = "PREREQUIS")
public class Prerequis implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@EmbeddedId
	private PrerequisPK			id;

	@Column(name = "NIVEAU_REQUIS")
	private int					niveauRequis;

	// bi-directional many-to-one association to Technologie
	@ManyToOne
	@JoinColumn(name = "TECHNOLOGIE_ID")
	private Technologie			technologie;

	// bi-directional many-to-one association to Technologie
	@ManyToOne
	@JoinColumn(name = "TECH_PREREQUIS")
	private Technologie			prerequis;

	public Prerequis() {

	}

	public PrerequisPK getId() {

		return this.id;
	}

	public void setId(PrerequisPK id) {

		this.id = id;
	}

	public int getNiveauRequis() {

		return this.niveauRequis;
	}

	public void setNiveauRequis(int niveauRequis) {

		this.niveauRequis = niveauRequis;
	}

	public Technologie getTechnologie() {

		return this.technologie;
	}

	public void setTechnologie(Technologie technologie) {

		this.technologie = technologie;
	}

	public Technologie getPrerequis() {

		return this.prerequis;
	}

	public void setPrerequis(Technologie prerequis) {

		this.prerequis = prerequis;
	}

}