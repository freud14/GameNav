package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COUT_ENERGIE database table.
 * 
 */
@Entity
@Table(name="COUT_ENERGIE")
public class CoutEnergie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TECHNOLOGIE_ID")
	private int technologieId;

	@Column(name="COUT_BASE")
	private int coutBase;

	@Column(name="COUT_MULTIPLICATEUR")
	private String coutMultiplicateur;

	@Column(name="GENERE_BASE")
	private String genereBase;

	@Column(name="GENERE_MULTIPLICATEUR")
	private String genereMultiplicateur;

	//bi-directional one-to-one association to Technologie
	@OneToOne
	@JoinColumn(name="TECHNOLOGIE_ID")
	private Technologie technologie;

	public CoutEnergie() {
	}

	public int getTechnologieId() {
		return this.technologieId;
	}

	public void setTechnologieId(int technologieId) {
		this.technologieId = technologieId;
	}

	public int getCoutBase() {
		return this.coutBase;
	}

	public void setCoutBase(int coutBase) {
		this.coutBase = coutBase;
	}

	public String getCoutMultiplicateur() {
		return this.coutMultiplicateur;
	}

	public void setCoutMultiplicateur(String coutMultiplicateur) {
		this.coutMultiplicateur = coutMultiplicateur;
	}

	public String getGenereBase() {
		return this.genereBase;
	}

	public void setGenereBase(String genereBase) {
		this.genereBase = genereBase;
	}

	public String getGenereMultiplicateur() {
		return this.genereMultiplicateur;
	}

	public void setGenereMultiplicateur(String genereMultiplicateur) {
		this.genereMultiplicateur = genereMultiplicateur;
	}

	public Technologie getTechnologie() {
		return this.technologie;
	}

	public void setTechnologie(Technologie technologie) {
		this.technologie = technologie;
	}

}