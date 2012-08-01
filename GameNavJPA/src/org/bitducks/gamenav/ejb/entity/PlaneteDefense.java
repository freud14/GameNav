package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PLANETE_DEFENSE database table.
 * 
 */
@Entity
@Table(name="PLANETE_DEFENSE")
public class PlaneteDefense implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlaneteDefensePK id;

	@Column(name="NOMBRE")
	private int nombre;

	//bi-directional many-to-one association to Defense
	@ManyToOne
	@JoinColumn(name="DEFENSE_ID")
	private Defense defense;

	//bi-directional many-to-one association to Planete
	@ManyToOne
	@JoinColumn(name="PLANETE_ID")
	private Planete planete;

	public PlaneteDefense() {
	}

	public PlaneteDefensePK getId() {
		return this.id;
	}

	public void setId(PlaneteDefensePK id) {
		this.id = id;
	}

	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public Defense getDefense() {
		return this.defense;
	}

	public void setDefense(Defense defense) {
		this.defense = defense;
	}

	public Planete getPlanete() {
		return this.planete;
	}

	public void setPlanete(Planete planete) {
		this.planete = planete;
	}

}