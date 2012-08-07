
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the GRPE_VAISSEAU_JOUEUR database table.
 * 
 */
@Entity
@Table(name = "GRPE_VAISSEAU_JOUEUR")
public class GrpeVaisseauJoueur implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int					id;

	@Column(name = "NOMBRE")
	private int					nombre;

	// bi-directional many-to-one association to JoueurUnivers
	@ManyToOne
	@JoinColumn(name = "JOUEUR_UNIVERS_ID")
	private JoueurUnivers		joueurUnivers;

	// bi-directional many-to-one association to Vaisseau
	@ManyToOne
	@JoinColumn(name = "VAISSEAU_ID")
	private Vaisseau			vaisseau;

	// bi-directional many-to-many association to Planete
	@ManyToMany(mappedBy = "grpeVaisseauJoueur")
	private List<Planete>		planete;

	// bi-directional many-to-many association to Trajet
	@ManyToMany(mappedBy = "grpeVaisseauJoueur")
	private List<Trajet>		trajet;

	public GrpeVaisseauJoueur() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public int getNombre() {

		return this.nombre;
	}

	public void setNombre(int nombre) {

		this.nombre = nombre;
	}

	public JoueurUnivers getJoueurUnivers() {

		return this.joueurUnivers;
	}

	public void setJoueurUnivers(JoueurUnivers joueurUnivers) {

		this.joueurUnivers = joueurUnivers;
	}

	public Vaisseau getVaisseau() {

		return this.vaisseau;
	}

	public void setVaisseau(Vaisseau vaisseau) {

		this.vaisseau = vaisseau;
	}

	public List<Planete> getPlanete() {

		return this.planete;
	}

	public void setPlanete(List<Planete> planete) {

		this.planete = planete;
	}

	public List<Trajet> getTrajet() {

		return this.trajet;
	}

	public void setTrajet(List<Trajet> trajet) {

		this.trajet = trajet;
	}

}