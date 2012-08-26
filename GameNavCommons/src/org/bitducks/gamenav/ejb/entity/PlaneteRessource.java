
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the PLANETE_RESSOURCE database table.
 * 
 */
@Entity
@Table(name = "PLANETE_RESSOURCE")
public class PlaneteRessource implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@EmbeddedId
	private PlaneteRessourcePK	id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DERNIERE_MAJ_RESSOURCE")
	private Date				derniereMajRessource;

	@Column(name = "NOMBRE")
	private int					nombre;

	// bi-directional many-to-one association to Planete
	@ManyToOne
	@JoinColumn(name = "PLANETE_ID", insertable = false, updatable = false)
	private Planete				planete;

	// bi-directional many-to-one association to Ressource
	@ManyToOne
	@JoinColumn(name = "RESSOURCE_ID", insertable = false, updatable = false)
	private Ressource			ressource;

	public PlaneteRessource() {

	}

	public PlaneteRessourcePK getId() {

		return this.id;
	}

	public void setId(PlaneteRessourcePK id) {

		this.id = id;
	}

	public Date getDerniereMajRessource() {

		return this.derniereMajRessource;
	}

	public void setDerniereMajRessource(Date derniereMajRessource) {

		this.derniereMajRessource = derniereMajRessource;
	}

	public int getNombre() {

		return this.nombre;
	}

	public void setNombre(int nombre) {

		this.nombre = nombre;
	}

	public Planete getPlanete() {

		return this.planete;
	}

	public void setPlanete(Planete planete) {

		this.planete = planete;
	}

	public Ressource getRessource() {

		return this.ressource;
	}

	public void setRessource(Ressource ressource) {

		this.ressource = ressource;
	}

}