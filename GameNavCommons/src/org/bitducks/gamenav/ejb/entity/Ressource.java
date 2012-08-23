
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the RESSOURCE database table.
 * 
 */
@Entity
@Table(name = "RESSOURCE")
public class Ressource implements Serializable {

	private static final long		serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int						id;

	@Column(name = "NOM")
	private String					nom;

	@Column(name = "NOMBRE_PLANETE_BASE")
	private int						nombrePlaneteBase;

	@Column(name = "ORDRE")
	private int						ordre;

	@Column(name = "PERISSABLE")
	private boolean					perissable;

	@Column(name = "PRODUCTION_BASE")
	private int						productionBase;

	// bi-directional many-to-one association to CoutRessource
	@OneToMany(mappedBy = "ressource")
	private List<CoutRessource>		coutRessource;

	// bi-directional many-to-one association to PlaneteRessource
	@OneToMany(mappedBy = "ressource")
	private List<PlaneteRessource>	planeteRessource;

	// bi-directional many-to-one association to TechnoRessource
	@OneToMany(mappedBy = "ressource")
	private List<TechnoRessource>	technoRessource;

	// bi-directional many-to-one association to TrajetRessource
	@OneToMany(mappedBy = "ressource")
	private List<TrajetRessource>	trajetRessource;

	public Ressource() {

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

	public int getNombrePlaneteBase() {

		return this.nombrePlaneteBase;
	}

	public void setNombrePlaneteBase(int nombrePlaneteBase) {

		this.nombrePlaneteBase = nombrePlaneteBase;
	}

	public int getOrdre() {

		return this.ordre;
	}

	public void setOrdre(int ordre) {

		this.ordre = ordre;
	}

	public boolean isPerissable() {

		return this.perissable;
	}

	public void setPerissable(boolean perissable) {

		this.perissable = perissable;
	}

	public int getProductionBase() {

		return this.productionBase;
	}

	public void setProductionBase(int productionBase) {

		this.productionBase = productionBase;
	}

	public List<CoutRessource> getCoutRessource() {

		return this.coutRessource;
	}

	public void setCoutRessource(List<CoutRessource> coutRessource) {

		this.coutRessource = coutRessource;
	}

	public List<PlaneteRessource> getPlaneteRessource() {

		return this.planeteRessource;
	}

	public void setPlaneteRessource(List<PlaneteRessource> planeteRessource) {

		this.planeteRessource = planeteRessource;
	}

	public List<TechnoRessource> getTechnoRessource() {

		return this.technoRessource;
	}

	public void setTechnoRessource(List<TechnoRessource> technoRessource) {

		this.technoRessource = technoRessource;
	}

	public List<TrajetRessource> getTrajetRessource() {

		return this.trajetRessource;
	}

	public void setTrajetRessource(List<TrajetRessource> trajetRessource) {

		this.trajetRessource = trajetRessource;
	}

}