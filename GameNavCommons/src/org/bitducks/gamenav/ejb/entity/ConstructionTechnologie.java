
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the CONSTRUCTION_TECHNOLOGIE database table.
 * 
 */
@Entity
@Table(name = "CONSTRUCTION_TECHNOLOGIE")
public class ConstructionTechnologie implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int					id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_DEBUT")
	private Date				dateDebut;

	@Column(name = "TEMPS_CONSTRUCTION")
	private int					tempsConstruction;

	// bi-directional many-to-one association to Planete
	@ManyToOne
	@JoinColumn(name = "PLANETE_ID")
	private Planete				planete;

	// bi-directional many-to-one association to Technologie
	@ManyToOne
	@JoinColumn(name = "TECHNOLOGIE_ID")
	private Technologie			technologie;

	public ConstructionTechnologie() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public Date getDateDebut() {

		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {

		this.dateDebut = dateDebut;
	}

	public Planete getPlanete() {

		return this.planete;
	}

	public void setPlanete(Planete planete) {

		this.planete = planete;
	}

	public Technologie getTechnologie() {

		return this.technologie;
	}

	public void setTechnologie(Technologie technologie) {

		this.technologie = technologie;
	}

	public int getTempsConstruction() {

		return this.tempsConstruction;
	}

	public void setTempsConstruction(int tempsConstruction) {

		this.tempsConstruction = tempsConstruction;
	}
}