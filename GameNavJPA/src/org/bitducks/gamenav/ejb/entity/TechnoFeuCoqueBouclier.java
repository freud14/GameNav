package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TECHNO_FEU_COQUE_BOUCLIER database table.
 * 
 */
@Entity
@Table(name="TECHNO_FEU_COQUE_BOUCLIER")
public class TechnoFeuCoqueBouclier implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TechnoFeuCoqueBouclierPK id;

	@Column(name="MULTIPLE_BOUCLIER")
	private String multipleBouclier;

	@Column(name="MULTIPLE_COQUE")
	private String multipleCoque;

	@Column(name="MULTIPLE_FEU")
	private String multipleFeu;

	//bi-directional many-to-one association to Technologie
	@ManyToOne
	@JoinColumn(name="TECHNOLOGIE_ID")
	private Technologie technologie;

	//bi-directional many-to-one association to Technologie
	@ManyToOne
	@JoinColumn(name="VAISSEAU_DEFENSE")
	private Technologie vaisseauDefense;

	public TechnoFeuCoqueBouclier() {
	}

	public TechnoFeuCoqueBouclierPK getId() {
		return this.id;
	}

	public void setId(TechnoFeuCoqueBouclierPK id) {
		this.id = id;
	}

	public String getMultipleBouclier() {
		return this.multipleBouclier;
	}

	public void setMultipleBouclier(String multipleBouclier) {
		this.multipleBouclier = multipleBouclier;
	}

	public String getMultipleCoque() {
		return this.multipleCoque;
	}

	public void setMultipleCoque(String multipleCoque) {
		this.multipleCoque = multipleCoque;
	}

	public String getMultipleFeu() {
		return this.multipleFeu;
	}

	public void setMultipleFeu(String multipleFeu) {
		this.multipleFeu = multipleFeu;
	}

	public Technologie getTechnologie() {
		return this.technologie;
	}

	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}

	public Technologie getVaisseauDefense() {
		return this.vaisseauDefense;
	}

	public void setVaisseauDefense(Technologie vaisseauDefense) {
		this.vaisseauDefense = vaisseauDefense;
	}

}