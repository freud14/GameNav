
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the TYPE_TECHNOLOGIE database table.
 * 
 */
@Entity
@Table(name = "TYPE_TECHNOLOGIE")
public class TypeTechnologie implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOM_TYPE_TECHNOLOGIE")
	private String				nomTypeTechnologie;

	// bi-directional many-to-one association to Technologie
	@OneToMany(mappedBy = "typeTechnologie")
	private List<Technologie>	technologie;

	public TypeTechnologie() {

	}

	public String getNomTypeTechnologie() {

		return this.nomTypeTechnologie;
	}

	public void setNomTypeTechnologie(String nomTypeTechnologie) {

		this.nomTypeTechnologie = nomTypeTechnologie;
	}

	public List<Technologie> getTechnologie() {

		return this.technologie;
	}

	public void setTechnologie(List<Technologie> technologie) {

		this.technologie = technologie;
	}

}