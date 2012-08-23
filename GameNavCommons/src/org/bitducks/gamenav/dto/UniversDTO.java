
package org.bitducks.gamenav.dto;

import java.util.Date;

public class UniversDTO {

	public int		id;

	public String	nom;

	public String	description;

	public Date		dateCreation;

	public UniversDTO(int id, String nom, String description, Date dateCreation) {

		super();
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.description = description;
	}

	public int getId() {

		return this.id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getNom() {

		return this.nom;
	}

	public void setNom(String nom) {

		this.nom = nom;
	}

	public String getDescription() {

		return this.description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public Date getDateCreation() {

		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {

		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {

		return "UniversDTO [id=" + this.id + ", nom=" + this.nom
				+ ", dateCreation=" + this.dateCreation + ", description="
				+ this.description + "]";
	}

}
