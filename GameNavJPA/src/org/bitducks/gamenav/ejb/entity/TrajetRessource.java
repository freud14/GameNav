package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TRAJET_RESSOURCE database table.
 * 
 */
@Entity
@Table(name="TRAJET_RESSOURCE")
public class TrajetRessource implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TrajetRessourcePK id;

	@Column(name="NOMBRE")
	private int nombre;

	//bi-directional many-to-one association to Ressource
	@ManyToOne
	@JoinColumn(name="RESSOURCE_ID")
	private Ressource ressource;

	//bi-directional many-to-one association to Trajet
	@ManyToOne
	@JoinColumn(name="TRAJET_ID")
	private Trajet trajet;

	public TrajetRessource() {
	}

	public TrajetRessourcePK getId() {
		return this.id;
	}

	public void setId(TrajetRessourcePK id) {
		this.id = id;
	}

	public int getNombre() {
		return this.nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public Trajet getTrajet() {
		return this.trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

}