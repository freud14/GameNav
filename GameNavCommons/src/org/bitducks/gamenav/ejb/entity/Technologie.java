
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the TECHNOLOGIE database table.
 * 
 */
@Entity
@Table(name = "TECHNOLOGIE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "NOM_TYPE_TECHNOLOGIE", discriminatorType = DiscriminatorType.STRING)
public abstract class Technologie implements Serializable {

	private static final long				serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int								id;

	@Lob
	@Column(name = "DESCRIPTION")
	private String							description;

	@Column(name = "HOMME_REQUIS")
	private int								hommeRequis;

	@Column(name = "MULTIPLICATEUR_HOMME")
	private int								multiplicateurHomme;

	@Column(name = "MULTIPLICATEUR_TEMPS")
	private int								multiplicateurTemps;

	@Column(name = "NOM")
	private String							nom;

	@Column(name = "TEMPS_CONSTRUCTION")
	private int								tempsConstruction;

	// bi-directional many-to-one association to ConstructionTechnologie
	@OneToMany(mappedBy = "technologie")
	private List<ConstructionTechnologie>	constructionTechnologie;

	// bi-directional one-to-one association to CoutEnergie
	@OneToOne(mappedBy = "technologie")
	private CoutEnergie						coutEnergie;

	// bi-directional many-to-one association to CoutRessource
	@OneToMany(mappedBy = "technologie")
	private List<CoutRessource>				coutRessource;

	// bi-directional many-to-one association to Prerequis
	@OneToMany(mappedBy = "technologie")
	private List<Prerequis>					prerequisTechno;

	// bi-directional many-to-one association to Prerequis
	@OneToMany(mappedBy = "prerequis")
	private List<Prerequis>					techoPrerequis;

	// bi-directional many-to-one association to TypeTechnologie
	@ManyToOne
	@JoinColumn(name = "NOM_TYPE_TECHNOLOGIE")
	private TypeTechnologie					typeTechnologie;

	// bi-directional many-to-one association to TechnoFeuCoqueBouclier
	@OneToMany(mappedBy = "technologie")
	private List<TechnoFeuCoqueBouclier>	technoFeuCoqueBouclier;

	// bi-directional many-to-one association to TechnoFeuCoqueBouclier
	@OneToMany(mappedBy = "vaisseauDefense")
	private List<TechnoFeuCoqueBouclier>	vaisseauDefenseFeuCoqueBouclier;

	// bi-directional many-to-one association to TechnoRessource
	@OneToMany(mappedBy = "technologie")
	private List<TechnoRessource>			technoRessource;

	public Technologie() {

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

	public int getHommeRequis() {

		return this.hommeRequis;
	}

	public void setHommeRequis(int hommeRequis) {

		this.hommeRequis = hommeRequis;
	}

	public int getMultiplicateurHomme() {

		return this.multiplicateurHomme;
	}

	public void setMultiplicateurHomme(int multiplicateurHomme) {

		this.multiplicateurHomme = multiplicateurHomme;
	}

	public int getMultiplicateurTemps() {

		return this.multiplicateurTemps;
	}

	public void setMultiplicateurTemps(int multiplicateurTemps) {

		this.multiplicateurTemps = multiplicateurTemps;
	}

	public String getNom() {

		return this.nom;
	}

	public void setNom(String nom) {

		this.nom = nom;
	}

	public int getTempsConstruction() {

		return this.tempsConstruction;
	}

	public void setTempsConstruction(int tempsConstruction) {

		this.tempsConstruction = tempsConstruction;
	}

	public List<ConstructionTechnologie> getConstructionTechnologie() {

		return this.constructionTechnologie;
	}

	public void setConstructionTechnologie(
			List<ConstructionTechnologie> constructionTechnologie) {

		this.constructionTechnologie = constructionTechnologie;
	}

	public CoutEnergie getCoutEnergie() {

		return this.coutEnergie;
	}

	public void setCoutEnergie(CoutEnergie coutEnergie) {

		this.coutEnergie = coutEnergie;
	}

	public List<CoutRessource> getCoutRessource() {

		return this.coutRessource;
	}

	public void setCoutRessource(List<CoutRessource> coutRessource) {

		this.coutRessource = coutRessource;
	}

	public List<Prerequis> getPrerequisTechno() {

		return this.prerequisTechno;
	}

	public void setPrerequisTechno(List<Prerequis> prerequisTechno) {

		this.prerequisTechno = prerequisTechno;
	}

	public List<Prerequis> getTechoPrerequis() {

		return this.techoPrerequis;
	}

	public void setTechoPrerequis(List<Prerequis> techoPrerequis) {

		this.techoPrerequis = techoPrerequis;
	}

	public TypeTechnologie getTypeTechnologie() {

		return this.typeTechnologie;
	}

	public void setTypeTechnologie(TypeTechnologie typeTechnologie) {

		this.typeTechnologie = typeTechnologie;
	}

	public List<TechnoFeuCoqueBouclier> getTechnoFeuCoqueBouclier() {

		return this.technoFeuCoqueBouclier;
	}

	public void setTechnoFeuCoqueBouclier(
			List<TechnoFeuCoqueBouclier> technoFeuCoqueBouclier) {

		this.technoFeuCoqueBouclier = technoFeuCoqueBouclier;
	}

	public List<TechnoFeuCoqueBouclier> getVaisseauDefenseFeuCoqueBouclier() {

		return this.vaisseauDefenseFeuCoqueBouclier;
	}

	public void setVaisseauDefenseFeuCoqueBouclier(
			List<TechnoFeuCoqueBouclier> vaisseauDefenseFeuCoqueBouclier) {

		this.vaisseauDefenseFeuCoqueBouclier = vaisseauDefenseFeuCoqueBouclier;
	}

	public List<TechnoRessource> getTechnoRessource() {

		return this.technoRessource;
	}

	public void setTechnoRessource(List<TechnoRessource> technoRessource) {

		this.technoRessource = technoRessource;
	}
}