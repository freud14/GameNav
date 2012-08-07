
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the TYPE_TRAJET database table.
 * 
 */
@Entity
@Table(name = "TYPE_TRAJET")
public class TypeTrajet implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int					id;

	@Lob
	@Column(name = "DESCRIPTION")
	private String				description;

	@Column(name = "NOM")
	private String				nom;

	// bi-directional many-to-one association to Trajet
	@OneToMany(mappedBy = "typeTrajet")
	private List<Trajet>		trajet;

	public TypeTrajet() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getDescription() {

		return this.description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public String getNom() {

		return this.nom;
	}

	public void setNom(String nom) {

		this.nom = nom;
	}

	public List<Trajet> getTrajet() {

		return this.trajet;
	}

	public void setTrajet(List<Trajet> trajet) {

		this.trajet = trajet;
	}

}