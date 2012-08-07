
package org.bitducks.gamenav.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the PLANETE database table.
 * 
 */
@Entity
@Table(name = "PLANETE")
public class Planete implements Serializable {

	private static final long				serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int								id;

	@Column(name = "EMPLACEMENT")
	private int								emplacement;

	@Column(name = "GALAXIE")
	private int								galaxie;

	@Column(name = "NOM")
	private String							nom;

	@Column(name = "SYSTEME_SOLAIRE")
	private int								systemeSolaire;

	// bi-directional many-to-one association to ConstructionTechnologie
	@OneToMany(mappedBy = "planete")
	private List<ConstructionTechnologie>	constructionTechnologie;

	// bi-directional many-to-many association to GrpeVaisseauJoueur
	@ManyToMany
	@JoinTable(name = "PLANETE_VAISSEAU", joinColumns = { @JoinColumn(name = "PLANETE_ID") }, inverseJoinColumns = { @JoinColumn(name = "GRPE_VAISSEAU_JOUEUR_ID") })
	private List<GrpeVaisseauJoueur>		grpeVaisseauJoueur;

	// bi-directional many-to-one association to JoueurUnivers
	@ManyToOne
	@JoinColumn(name = "JOUEUR_UNIVERS_ID")
	private JoueurUnivers					joueurUnivers;

	// bi-directional many-to-one association to PlaneteBatiment
	@OneToMany(mappedBy = "planete")
	private List<PlaneteBatiment>			planeteBatiment;

	// bi-directional many-to-one association to PlaneteDefense
	@OneToMany(mappedBy = "planete")
	private List<PlaneteDefense>			planeteDefense;

	// bi-directional many-to-one association to PlaneteRessource
	@OneToMany(mappedBy = "planete")
	private List<PlaneteRessource>			planeteRessource;

	// bi-directional many-to-one association to Trajet
	@OneToMany(mappedBy = "depart")
	private List<Trajet>					trajetDepart;

	// bi-directional many-to-one association to Trajet
	@OneToMany(mappedBy = "destination")
	private List<Trajet>					trajetDestination;

	public Planete() {

	}

	public int getId() {

		return this.id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public int getEmplacement() {

		return this.emplacement;
	}

	public void setEmplacement(int emplacement) {

		this.emplacement = emplacement;
	}

	public int getGalaxie() {

		return this.galaxie;
	}

	public void setGalaxie(int galaxie) {

		this.galaxie = galaxie;
	}

	public String getNom() {

		return this.nom;
	}

	public void setNom(String nom) {

		this.nom = nom;
	}

	public int getSystemeSolaire() {

		return this.systemeSolaire;
	}

	public void setSystemeSolaire(int systemeSolaire) {

		this.systemeSolaire = systemeSolaire;
	}

	public List<ConstructionTechnologie> getConstructionTechnologie() {

		return this.constructionTechnologie;
	}

	public void setConstructionTechnologie(
			List<ConstructionTechnologie> constructionTechnologie) {

		this.constructionTechnologie = constructionTechnologie;
	}

	public List<GrpeVaisseauJoueur> getGrpeVaisseauJoueur() {

		return this.grpeVaisseauJoueur;
	}

	public void setGrpeVaisseauJoueur(
			List<GrpeVaisseauJoueur> grpeVaisseauJoueur) {

		this.grpeVaisseauJoueur = grpeVaisseauJoueur;
	}

	public JoueurUnivers getJoueurUnivers() {

		return this.joueurUnivers;
	}

	public void setJoueurUnivers(JoueurUnivers joueurUnivers) {

		this.joueurUnivers = joueurUnivers;
	}

	public List<PlaneteBatiment> getPlaneteBatiment() {

		return this.planeteBatiment;
	}

	public void setPlaneteBatiment(List<PlaneteBatiment> planeteBatiment) {

		this.planeteBatiment = planeteBatiment;
	}

	public List<PlaneteDefense> getPlaneteDefense() {

		return this.planeteDefense;
	}

	public void setPlaneteDefense(List<PlaneteDefense> planeteDefense) {

		this.planeteDefense = planeteDefense;
	}

	public List<PlaneteRessource> getPlaneteRessource() {

		return this.planeteRessource;
	}

	public void setPlaneteRessource(List<PlaneteRessource> planeteRessource) {

		this.planeteRessource = planeteRessource;
	}

	public List<Trajet> getTrajetDepart() {

		return this.trajetDepart;
	}

	public void setTrajetDepart(List<Trajet> trajetDepart) {

		this.trajetDepart = trajetDepart;
	}

	public List<Trajet> getTrajetDestination() {

		return this.trajetDestination;
	}

	public void setTrajetDestination(List<Trajet> trajetDestination) {

		this.trajetDestination = trajetDestination;
	}

}